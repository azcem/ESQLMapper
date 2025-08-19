# ESQL Data Mapping Documentation Generator

A powerful ANTLR-based application that parses ESQL (Exteneded SQL) code and automatically generates comprehensive DOCX documentation tables showing data format mappings and transformations.

## Features

- **ESQL Parser**: Built with ANTLR for robust parsing of ESQL syntax
- **Automatic Mapping Detection**: Identifies data transformations, field mappings, and format conversions
- **DOCX Generation**: Creates professional documentation tables in Microsoft Word format
- **Schema Analysis**: Extracts source and target data schemas from ESQL code
- **Transformation Tracking**: Documents complex data manipulations and business logic

## Quick Start

```bash
# Clone the repository
git clone https://github.com/azcem/ESQLMapper.git
cd ESQLMapper

# Install dependencies
pip install -r requirements.txt

# Run the application
python main.py --filename input.esql -o mapping.docx --source Environment/Variables/Data --source-mapped "/Body" --target OutputRoot/XMLNSC --target-mapped "/" --table-title "Sample Mapping"
```

## Installation

### Prerequisites

- Java 8+ (for ANTLR runtime)
- Python 3.8+
- ANTLR 4.x

### From Source

```bash
git clone https://github.com/azcem/ESQLMapper.git
cd ESQLMapper

# Install ANTLR
npm install -g antlr4
```

## Usage

### Basic Usage

First, Supply template.docx file to get the table theme from.

```bash
python main.py --filename input.esql -o mapping.docx --source Environment/Variables/Data --source-mapped "/Body" --target OutputRoot/XMLNSC --target-mapped "/" --table-title "Sample Mapping"
```

### Command Line Options

| Option | Description |
|--------|-------------|
| `-h, --help` | Show this help message and exit |
| `--filename, -f FILENAME` | Filename of ESQL code |
| `--source, -s SOURCE` | Path of source to be replace with /Body |
| `--target, -t TARGET` | Path of target to be replaced with /Body |
| `--source-mapped, -sm SOURCE_MAPPED` | Path of source to appear on docx table |
| `--target-mapped, -tm TARGET_MAPPED` | Path of target to appear on docx table |
| `-o O` | Output docx filename |
| `--table-title, -tt TABLE_TITLE` | Title of docx table |


## ESQL Support

### Supported ESQL Features

- **Data Transformations**: DECLARE and SET statements
- **Database Operations**: SQL statements and stored procedure calls
- **XML/JSON Parsing**: Message tree navigation and manipulation
- **Error Handling**: TRY/CATCH blocks and error propagation

### Example ESQL Input

```sql
DECLARE outputRoot ROW;
CREATE FIRSTCHILD OF outputRoot DOMAIN 'JSON';
CREATE LASTCHILD OF outputRoot.JSON NAME 'Data';

SET outputRoot.JSON.Data.CustomerID = inputRoot.XMLNSC.Customer.ID;
SET outputRoot.JSON.Data.CustomerName = inputRoot.XMLNSC.Customer.Name;
SET outputRoot.JSON.Data.OrderDate = CAST(inputRoot.XMLNSC.Order.Date AS DATE);

PROPAGATE TO TERMINAL 'out';
```

## Output Documentation

The generated DOCX includes:

### Mapping Tables


<table>
<tr><th>Sample Mapping</th></tr>
<tr><th>XPATH/Element</th><th>Source Element (Expression)</th></tr>
<tr><td>/CustomerID</td><td>/Body/Customer/ID</td></tr>
<tr><td>/CustomerName</td><td>/Body/Customer/Name</td></tr>
<tr><td>/OrderDate</td><td>CAST(/Body/Order/Date AS DATE)</td></tr>
</table>

### Flow Summary

- **Input Format**: XML (XMLNSC domain)
- **Output Format**: JSON
- **Transformation Type**: Format conversion with data type casting
- **Error Handling**: None specified


## API Reference

### Python

```python
from TableWriter.TableWriter import TableWriter
import subprocess
process = subprocess.Popen(
    ['java', 'Mapper/mkmapping', args.filename, args.source, args.source_mapped, args.target, args.target_mapped],
    stdout=subprocess.PIPE,
    stderr=subprocess.PIPE,
    text=True
)

tw = TableWriter(args.table_title, args.output)
for line in process.stdout:
    row = [str.strip() for str in line.split(';')]
    tw.write_row(row)
tw.save()
```

## Development

### Project Structure

```
📁 Grammar/
├── 📄 ESQL.g4
📁 Mapper/
├── 🔶 ESQL.iml
├── 📄 ESQL.interp
├── 📄 ESQL.tokens
├── ☕ ESQLBaseListener.java
├── 📄 ESQLLexer.interp
├── ☕ ESQLLexer.java
├── 📄 ESQLLexer.tokens
├── ☕ ESQLListener.java
├── ☕ ESQLMapper.java
├── ☕ ESQLParser.java
└── ☕ mkmapping.java
📁 TableWriter/
├── 🐍 TableWriter.py
🐍 main.py
📄 requirements.txt
📄 template.docx
```

### Building from Source

```bash
# compile java parser
cd Mapper
javac *.java
```

## Troubleshooting

### Common Issues

**Parser Errors**
```
Error: Unexpected token at line 42
```
- Check ESQL syntax
- Ensure proper statement termination
- Verify balanced parentheses and quotes

**Missing Dependencies**
```
Error: ANTLR runtime not found
```
- Install Java 8+
- Verify ANTLR installation: `antlr4 -version`

**Output Generation Fails**
```
Error: Cannot write to output file
```
- Check file permissions
- Ensure output directory exists
- Verify DOCX template is valid

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Related Projects

- [IBM Integration Bus Documentation](https://www.ibm.com/docs/en/integration-bus)
- [ANTLR Project](https://www.antlr.org/)
- [DocX Template Engine](https://github.com/open-xml-templating/docxtemplater)

## Acknowledgments

- Built with [ANTLR](https://www.antlr.org/) for parsing
- Uses [python-docx](https://python-docx.readthedocs.io/en/latest/) for document generation
- Inspired by enterprise integration documentation needs

---

**Made with ❤️ for the integration community**
