## LDTS_T06_G04 - Crossy Road

Crossy Road is an endless arcade hopper game that derives its name and concept from the age-old “why did the chicken cross the road?” joke. The goal is to move the game character (Chicken) as much time as possible through a hazardous path of busy roads and tree-crowded sidewalks. At the bottom and top of the screen there are two safezones where the difficulty increases every time the character manages to get from one to the other.

This project was developed by Bruno Fernandes (up202108871@edu.fe.up.pt), José Santos (up202108729@edu.fe.up.pt) and Vasco Oliveira (up202108881@edu.fe.up.pt) for LDTS 2022-23.

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



## KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS
#### **Lazy Classes**
The `TreeViewer` and `CarViewer` classes don't do much.

A way to improve would be to move their methods to another class, using refactoring tools.

#### **Large Classes**
The `Arena` class contains many fields and the `LanternaGUI` class contains many methods. In both cases, we find it well founded as the first one requires these fields, because it is the main class of the program and it needs to store a substantial amount of data. The second class needs all these methods and it wouldn't make sense to split them into two separate classes (extract method).

#### **Data Class**
All model classes are Data Classes, as they contain only fields, and no behavior (dumb classes). This is caused by the **MVC** (Model-View-Controller) architectural pattern which holds the responsibility to the controller to implement the logic functionalities of each model.
This is not a bad code smell because it only exists due to the chosen design pattern.

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

