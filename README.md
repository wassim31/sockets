# Sockets in C & Java API

This repository contains implementations of socket programming in C & java , demonstrating basic client-server communication using TCP and UDP protocols. It provides practical examples for creating, managing, and handling sockets, using the standard C socket API.

## Features

- **TCP Client-Server Communication**: Example of connection-oriented communication using `SOCK_STREAM` for reliable data transmission.
- **UDP Client-Server Communication**: Demonstrates connectionless communication using `SOCK_DGRAM`, suitable for faster, less reliable data exchange.
- **Cross-platform**: Works on Linux environments and other POSIX-compliant systems.

## Getting Started

### Prerequisites
- GCC or any C compiler.
- POSIX-compliant operating system (Linux, macOS).
- Basic knowledge of C & java programming.

### Compilation
Use `gcc or javac` to compile the programs. Example for compiling the TCP client and server:

```bash
gcc -o server tcp_server.c
gcc -o client tcp_client.c
```
