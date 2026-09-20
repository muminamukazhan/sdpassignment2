# Logistics Delivery Application — Factory Method & Abstract Factory

## Project Purpose
This is a console-based Java application that demonstrates two creational design patterns working together:

- **Factory Method** — used to create the delivery transport (`Truck` or `Ship`) based on the selected delivery mode (`ROAD` or `SEA`).
- **Abstract Factory** — used to create a matching family of UI components (`Button` and `Checkbox`) based on the selected platform (`WINDOWS` or `MACOS`).

At runtime, the user selects a delivery mode and a UI platform independently. The application then renders the correct UI component pair and performs the correct delivery, without any code changes, using the abstract contracts (`Transport`, `Logistics`, `Button`, `Checkbox`, `GUIFactory`) rather than concrete classes.

## Package Structure

src/
└── com/
├── logistics/
│ ├── transport/
│ │ ├── Transport.java // Product interface (Factory Method)
│ │ ├── Truck.java // Concrete product
│ │ └── Ship.java // Concrete product
│ └── creator/
│ ├── Logistics.java // Abstract creator
│ ├── RoadLogistics.java // Concrete creator
│ └── SeaLogistics.java // Concrete creator
│
├── gui/
│ ├── component/
│ │ ├── Button.java // Abstract product (Abstract Factory)
│ │ ├── Checkbox.java // Abstract product
│ │ ├── WindowsButton.java // Concrete product
│ │ ├── WindowsCheckbox.java // Concrete product
│ │ ├── MacOSButton.java // Concrete product
│ │ └── MacOSCheckbox.java // Concrete product
│ └── factory/
│ ├── GUIFactory.java // Abstract factory
│ ├── WindowsFactory.java // Concrete factory
│ └── MacOSFactory.java // Concrete factory
│
└── app/
├── DeliveryMode.java // Enum: ROAD, SEA
├── UIPlatform.java // Enum: WINDOWS, MACOS
├── InputReader.java // Reads and validates console/argument input
├── LogisticsSelector.java // Selects concrete Logistics by mode
├── GUIFactorySelector.java // Selects concrete GUIFactory by platform
├── DeliveryApplication.java // Client: uses GUIFactory + Logistics via interfaces
└── Main.java // Entry point


## Prerequisites

- **JDK 17** or newer installed and available on the `PATH`
- No external libraries, build tools, or frameworks are required
- Any OS (Windows, macOS, or Linux) — selecting the "macOS" UI family does **not** require running on macOS, since it only prints text

Verify your JDK version:

```bash
java -version
javac -version
```

## Build and Run Instructions

1. Clone the repository and move into its root folder:
```bash
   git clone https://github.com/muminamukazhan/sdpassignment2.git
   cd sdpassignment2
```

2. Compile all source files into an `out` directory:
```bash
   javac -d out $(find src -name "*.java")
```
   (On Windows PowerShell, use: `javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName`)

3. Run the application, passing the delivery mode and UI platform as command-line arguments:
```bash
   java -cp out com.app.Main ROAD WINDOWS
```

   Alternatively, run it with no arguments and enter the values interactively when prompted:
```bash
   java -cp out com.app.Main
```

## Supported Input Values

| Parameter      | Supported values   | Case-insensitive |
|----------------|---------------------|-------------------|
| Delivery mode  | `ROAD`, `SEA`        | Yes |
| UI platform    | `WINDOWS`, `MACOS`   | Yes |

- If an argument is omitted, the program prompts for it on the console.
- If an unsupported value is entered (e.g. `AIR` or `LINUX`), the program prints a clear validation message and stops cleanly — it never falls back to a default or continues with an invalid choice.
- If input is missing entirely (empty line / end of input), the program prints a message and stops cleanly as well.

## Sample Run

$ java -cp out com.app.Main ROAD WINDOWS
Delivery mode: ROAD
UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment to Aktau warehouse by road


Changing only the platform (`ROAD MACOS`) replaces the UI pair while keeping the same transport; changing only the delivery mode (`SEA WINDOWS`) replaces the transport while keeping the same UI family. All four combinations of `{ROAD, SEA} x {WINDOWS, MACOS}` run without any code changes.

## Design Patterns Applied

- **Factory Method** (`Logistics` → `RoadLogistics` / `SeaLogistics`): defers creation of a single product (`Transport`) to subclasses, while sharing the `planDelivery(...)` workflow in the base class.
- **Abstract Factory** (`GUIFactory` → `WindowsFactory` / `MacOSFactory`): creates a consistent family of related products (`Button` + `Checkbox`) so that components from different platforms can never be mixed.
