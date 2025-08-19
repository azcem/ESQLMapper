from TableWriter.TableWriter import TableWriter
import subprocess
import argparse

parser = argparse.ArgumentParser(description="Maps ESQL code to docx table.")

parser.add_argument('--filename', '-f', help='filename of ESQL code.', required=True)
parser.add_argument('--source', '-s', help='path of source to be replace with /Body.', required=True)
parser.add_argument('--target', '-t', help='path of target to be replaced with /Body.', required=True)
parser.add_argument('--source-mapped', '-sm', default='/Body', help='path of source to appear on docx table.')
parser.add_argument('--target-mapped', '-tm', default='/Body', help='path of target to appear on docx table.')
parser.add_argument('-o', help='output docx filename.', default='mapping.docx')
parser.add_argument('--table-title', '-tt', help='title of docx table.', required=True)

args = parser.parse_args()

process = subprocess.Popen(
    ['java', 'Mapper/mkmapping', args.filename, args.source, args.source_mapped, args.target, args.target_mapped],
    stdout=subprocess.PIPE,
    stderr=subprocess.PIPE,
    text=True
)

tw = TableWriter(args.table_title, args.o)
for line in process.stdout:
    row = [str.strip() for str in line.split(';')]
    tw.write_row(row)
tw.save()