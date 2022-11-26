## LDTS_0604 - Crossy Road

Crossy Road is an endless arcade hopper game that derives its name and concept from the age-old “why did the chicken cross the road?” joke. The goal is to move the game character (Chicken) as much time as possible through a hazardous path of busy roads and tree-crowded sidewalks. At the bottom and top of the screen there are two safezones where the difficulty increases every time the character manages to get from one to the other.

This project was developed by Bruno Fernandes (up202108871@fe.up.pt), José Santos (up202108729@fe.up.pt) and Vasco Oliveira (up202108881@fe.up.pt) for LDTS 2022/23.

### IMPLEMENTED FEATURES
- **Moving the character** - The player can control the character's movements using the arrow keys.
- **Random Generation of Trees and Cars** - The elements in the map are all randomly generated so every time the game is played the player can have a different experience.
- **Car Movement** - The cars are always moving, switching sides if they move out of the map.

![Screenshot from 2022-11-26 02-08-07](https://user-images.githubusercontent.com/114070737/204068287-38fe9588-fc82-4b67-a9ae-8f988f75b52b.png)

### PLANNED FEATURES

- **Colision with Cars** - When the player colides with a car the game should end and open a menu, letting the player play again or exit the game.
- **Randomized trees in sidewalks** - Every time the game character gets to a safezone, difficulty increases and the trees in all the sidewalks will be in randomized positions.
- **Coins** - Every time the game character catches a coin, his balance is increased.
- **Shop** - The game character can have multiple colors, which he can buy in the shop.
- **Power ups** - The game character can have multiple power ups that have different benefits to it.

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

### TESTING

**Screenshot of coverage report:**
![Screenshot from 2022-11-26 03-49-00](https://user-images.githubusercontent.com/114070737/204071346-7cc47a56-eb7a-496c-841d-7cd28f0ddfbc.png)


### SELF-EVALUATION

- Bruno Fernandes: 32.5%
- José Santos: 35%
- Vasco Oliveira: 32.5%


