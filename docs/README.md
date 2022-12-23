## LDTS_T06_G04 - Crossy Road

Crossy Road is an endless arcade hopper game that derives its name and concept from the age-old “why did the chicken cross the road?” joke. The goal is to move the game character (Chicken) as much time as possible through a hazardous path of busy roads and tree-crowded sidewalks. At the bottom and top of the screen there are two safezones where the difficulty increases every time the character manages to get from one to the other.

This project was developed by Bruno Fernandes (up202108871@fe.up.pt), José Santos (up202108729@fe.up.pt) and Vasco Oliveira (up202108881@fe.up.pt) for LDTS 2022-23.

## UML Class Diagram
![image](https://user-images.githubusercontent.com/93687600/204073034-2c6c0320-77dd-4dd0-a73f-d5a34a7f793b.png)

### IMPLEMENTED FEATURES

- **Connected Menus** - The user has the power of browsing through the different menus including the ones that can only be accessed in-game. (Ex: Main Menu, Instructions, Shop, PowerUps and Skins);
- **Keyboard Control** - The keyboard inputs are received through the respective events and interpreted according to the current game state.
- **Collisions Detection** - Collisions between different objects are verified. (Ex: Chicken, Cars, Trees, Coins).
- **Moving the Character** - The player can control the character's movements using the arrow keys and use a powerUp when the correct key is pressed. (Ex: Teleport PowerUp can be used using the Spacebar key);
- **Shop Interaction and Money Management** - The player may buy powerUps in the in game shop and also change the color of the game character.
- **Random Generation of Trees and Cars** - The elements in the map are all randomly generated so every time the game is played the player can have a different experience.
- **Tree and Coin Randomizing** - Every time the player manages to get the character from one safezone to the other the trees randomly change position. Coins randomly change position every 10 seconds.
- **Car Movement** - The cars are always moving, switching sides if they move out of the map.

### PLANNED FEATURES

All the planned features were successfully implemented.

### DESIGN

#### GENERATING CARS THAT MOVE IN DIFFERENT DIRECTIONS

**Problem in Context**

There were no reliable ideas for a way to generate the cars in the roads in a random but organized way, as their position should be random but the roads should have defined directions. If we would have generated all the cars individually the code wouldn't be clean.

**The Pattern**
We have applied the **Composite** pattern. This pattern allows you to represent part-whole hierarchies of objects and lets the clients ignore the difference between compositions of objects and individual objects. This pattern alloed to solve our problem by having two types of cars but having the same method generating them all.

**Implementation**

These classes can be found in the following files:
- [Car](https://github.com/FEUP-LDTS-2022/project-l06gr04/blob/main/src/main/java/com/aor/crossyroad/model/game/elements/cars/Car.java)
- [CarLeft](https://github.com/FEUP-LDTS-2022/project-l06gr04/blob/main/src/main/java/com/aor/crossyroad/model/game/elements/cars/CarLeft.java)
- [CarRight](https://github.com/FEUP-LDTS-2022/project-l06gr04/blob/main/src/main/java/com/aor/crossyroad/model/game/elements/cars/CarRight.java)

**Consequences**
The use of the Composite Pattern has the following benefits:

- Simpler clients
- Easier to implement new commands

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

**CHICKEN DRAW DOESN'T DRAW OVER SAFEZONE LINES**
The `drawChicken()` function in the `LanternaGUI` class draws under the lines that bound the safezones, making the character "disappear" while in that line.

A way to improve the code would be to add a condition in the method `moveChicken()`, that makes the character "jump" over the bounds. 

**LAZY CLASSES**
The `TreeViewer` and `CarViewer` classes don't do much.

A way to improve would be to move their methods to another class, using refactoring tools.

**LARGE CLASS**
The `LanternaGUI` class contains a lot of methods and lines of code.

A way to improve would be to either simplify said methods or divide them in multiple classes, using refactoring tools.

## TESTING

### Screenshot of coverage report
<p align="center" justify="center">
  <img src="images/screenshots/codeCoverage"/>
</p>
<p align="center">
  <b><i>Fig 6. Code coverage screenshot</i></b>
</p>



### Link to mutation testing report
[Mutation tests](../build/reports/pitest)

### SELF-EVALUATION

- Bruno Fernandes: 32.5%
- José Santos: 35%
- Vasco Oliveira: 32.5%

