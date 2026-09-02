# Padkapao Good

Padkapao Good is a Thai-language desktop cooking game built with Java Swing. Take customer orders, choose the requested ingredients, cook on two stoves, package each dish, and serve it before the three-minute round ends.

## Features

- Randomized pad kapao orders with many ingredient combinations
- Main and extra ingredient-selection screens
- Two independently timed cooking stations
- Packaging, serving, scoring, and restart flow
- Order hints, pause controls, and sound effects
- All images and audio bundled with the application

## Requirements

- A desktop environment with a display and audio support
- Java 23 or newer to run the included JAR
- JDK 23 or newer to compile the project from source

Check your installed Java version with:

```bash
java -version
```

## Run the game

From this directory, launch the included executable JAR:

```bash
java -jar "Padkapao Good.jar"
```

You can also run the included compiled classes:

```bash
java -cp bin Main.MainClass
```

The game opens in a fixed `1680 × 1050` window. A display at least that large is recommended.

## How to play

1. Select the play button on the title screen.
2. Read the customer's order. Use the **Hint** or **What** button when it is available if you need help interpreting it.
3. Move to the ingredient screen and select every ingredient requested by the customer. Extra ingredients are available from the additional-ingredients button.
4. Select the prepared dish to place it on an available stove. Each stove cooks for 15 seconds; collect the dish before it burns.
5. Move the cooked dish into a box, close the box, and serve it to the customer.
6. Complete as many accurate orders as possible before the 180-second game timer expires.

Use the trash button to clear the current ingredients or stove contents. The pause, sound, and exit buttons are available from the game interface.

## Build from source

The project uses only the Java standard library and does not require Maven or Gradle.

```bash
rm -rf out
mkdir -p out
javac -d out $(find src -name "*.java")
cp -R src/resources out/resources
jar cfm padkapao-good.jar manifest.txt -C out .
```

Run the newly built artifact with:

```bash
java -jar padkapao-good.jar
```

## Project structure

```text
.
├── src/
│   ├── Main/        # Game state, scenes, scoring, timers, and entry point
│   ├── animation/   # Customer entrance and exit animations
│   ├── entity/      # Orders, dialogs, and animated customer components
│   ├── sound/       # Audio playback helpers
│   ├── ui/          # Reusable interface controls
│   └── resources/   # Images and audio used by the game
├── bin/             # Precompiled classes and copied resources
├── manifest.txt     # JAR entry-point configuration
└── Padkapao Good.jar
```

The application entry point is `Main.MainClass`.
