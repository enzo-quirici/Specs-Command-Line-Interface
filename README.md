[![Java](https://img.shields.io/badge/Java-17%2F21-blue.svg?logo=java)](https://adoptium.net/) [![FreeBSD](https://img.shields.io/badge/FreeBSD-supported-red.svg?logo=freebsd)](https://www.freshports.org/java/openjdk17/) [![GhostBSD](https://img.shields.io/badge/GhostBSD-supported-3f5cff.svg?logo=ghost)](https://www.ghostbsd.org/) [![Linux](https://img.shields.io/badge/Linux-supported-green.svg?logo=linux)](https://openjdk.java.net/) [![macOS](https://img.shields.io/badge/macOS-supported-lightgrey.svg?logo=apple)](https://adoptium.net/) [![Windows](https://img.shields.io/badge/Windows-supported-blue.svg?logo=windows)](https://adoptium.net/) [![Arch Linux](https://img.shields.io/badge/Arch-Linux-blue.svg?logo=arch-linux)](https://archlinux.org/packages/?q=openjdk) [![Debian](https://img.shields.io/badge/Debian-supported-a80030.svg?logo=debian)](https://packages.debian.org/search?keywords=openjdk) [![Fedora](https://img.shields.io/badge/Fedora-supported-294172.svg?logo=fedora)](https://src.fedoraproject.org/rpms/java-17-openjdk) [![Gentoo](https://img.shields.io/badge/Gentoo-supported-54487a.svg?logo=gentoo)](https://packages.gentoo.org/packages/dev-java/openjdk)

---

# Specs CLI

Specs CLI is a Java command-line application that displays detailed information about your PC's hardware. It works on Windows, Linux, and Mac OS using a standalone `.jar` file.  

## Features

- **CPU Details**: View processor model, physical and logical core count.  
- **GPU Information**: Display GPU name and VRAM capacity.  
- **RAM Usage**: Shows total, used, and free memory (excluding cached files).  
- **Operating System**: Displays OS name and version.  

## Minimum Requirements

- 🖥️ **OS**: Windows 7 or later / Linux 4.4 or later / Mac OS 10.11 or later  
- ⚙️ **CPU**: 64-bit processor  
- 💾 **RAM**: 512 MB  
- 💿 **Storage**: 512 MB free space  
- ☕ **Java**: JDK 17 or later  

## Getting Started

1. Make sure you have **Java 17 or newer** installed on your system.
2. Download the `Specs.jar` file from this repository.
3. Open a terminal or command prompt and navigate to the folder containing `Specs.jar`.
4. Run the application:

```bash
java -jar Specs.jar
```
You should see detailed information about your CPU, GPU, RAM, and operating system in the terminal.

## glxinfo :  

- GLXINFO has been replaced with OSHI GLXINFO is now optional.  

- To enable GPU and VRAM information retrieval on Linux, this program requires `glxinfo`. Below are the instructions for installing `glxinfo` on Debian, Ubuntu, Fedora, Arch Linux, and Gentoo.  

### Debian / Ubuntu :
On Debian or Ubuntu, `glxinfo` is part of the `mesa-utils` package :
```bash
sudo apt-get update
sudo apt-get install mesa-utils
```
### Fedora :
On Fedora, you can install glxinfo with the mesa-demos package :
```bash
sudo dnf install mesa-demos
```
### Arch Linux :
On Arch Linux, glxinfo is provided by the mesa-demos package :
```bash
sudo pacman -S mesa-demos
```
### Gentoo :
On Gentoo, you can install glxinfo by emerging the mesa-progs package :
```
sudo emerge --ask mesa-progs -av
```
### Verifying the Installation :
To confirm that glxinfo is installed correctly, run :
```bash
glxinfo | grep "OpenGL version"
```
If glxinfo returns OpenGL version information, the installation was successful.

## Project Status :

### Legend :
- ✅ Yes
- ❌ No
- ⚠️ Partial or Special Case
- 🟧 Not Available/Unknown

| OS           | Launch    | Installer | Standalone Version   | OS | CPU  | RAM  | VRAM  |
|--------------|-----------|-----------|----------------------|----|------|------|-------|
| Windows      | ✅        | ✅        | ✅                  | ✅ | ✅  | ✅   | ✅    |
| Arch Linux   | ✅        | ✅        | ✅                  | ✅ | ✅  | ✅   | ✅    |
| Ubuntu       | ✅        | ✅        | ✅                  | ✅ | ✅  | ✅   | ✅    |
| Debian       | ✅        | ✅        | ✅                  | ✅ | ✅  | ✅   | ✅    |
| Fedora       | ✅        | ✅        | ✅                  | ✅ | ✅  | ✅   | ✅    |
| Gentoo Linux | ✅        | ✅        | ✅                  | ✅ | ✅  | ✅   | ✅    |
| Mac OS       | ✅        | ✅        | ✅                  | ✅ | ✅  | ✅   | ✅    |

# Validation :

- the validation feature is a feature that allows you to display information from multiple PCs to create statistics.
- This feature requires a server to be used.  
- currently there is no official server available, but you can create one by using the guide [how to create you own Specs Server](https://github.com/enzo-quirici/Specs-Server/).
