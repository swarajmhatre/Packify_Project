# Java File Zipper and Unzipper

This Java project provides a simple way to zip and unzip multiple files using two main components: `Packer.java` and `Unpacker.java`. The `Packer` class allows you to create a compressed archive of files from a specified folder, while the `Unpacker` class lets you extract files from the generated archive.

## Table of Contents

- [Features](#features)
- [Usage](#usage)
- [Installation](#installation)
- [How it Works](#how-it-works)
- [Contributing](#contributing)
- [License](#license)

## Features

- **File Zipping:** Use the `Packer` class to compress files from a specified folder into a single archive.
- **File Unzipping:** Utilize the `Unpacker` class to extract files from the generated archive.
- **Customizable Archive Name:** You can specify the desired name for the output archive file when using the `Packer`.

## Usage

### Prerequisites

Before using this project, ensure you have the following prerequisites installed on your system:

- Java Development Kit (JDK)
- Git (optional, for cloning the repository)

### Installation

1. Clone this repository to your local machine using the following command (if you haven't already):

   ```bash
   git clone https://github.com/your-username/your-repo.git
   ```

2. Compile the Java source files:

   ```bash
   javac Packer.java Unpacker.java
   ```

3. You are now ready to use the `Packer` and `Unpacker` classes.

### How it Works

#### Packing Files

To create a compressed archive, follow these steps:

1. Open a terminal.

2. Navigate to the project directory containing the compiled `.class` files.

3. Run the `Packer` class with the following command:

   ```bash
   java Packer
   ```
3. When asked, give the folder name containing the files to be compressed:

   ```bash
   java Packer
   ```
4. Give the output file any name you want.

5. A compressed text file named `givenName.txt` will be created in the same directory.

#### Unpacking Files

To extract files from the archive, follow these steps:

1. Open a terminal.

2. Navigate to the project directory containing the compiled `.class` files.

3. Run the `Unpacker` class with the following command:

   ```bash
   java Unpacker
   ```

4. Enter the text file name created when Packing.

5. The files from the compressed text file will be extracted to the current directory.

## Contributing

Contributions are welcome! If you have any suggestions, improvements, or bug fixes, please open an issue or create a pull request. For major changes, please discuss them in advance.

## License

This project is licensed under the MIT License.
