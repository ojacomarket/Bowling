# Bowling API :bowling:
## This code was a part of interview test 

### :hammer:Technical description:
**Project is runnable wherever JVM is installed:**

### :dart:What it does?
- Ability to throw a ball and down the pins
- Ability to ask player's current score
- Ability to view fancy output of the whole score table in a console

### :clapper:Howto
1. To play a frame call ***throwBall*** for frames 1-9, which accepts 3 parameters, scored pins from first roll, second roll and player's name
2. When frames nr. is 10, last frame, switch your frame to ***throwBall*** , which accpets 4 parameters, *additional* that came into game is third roll
3. To ask player's current score just call ***showCurrentScore()*** method, which accepts 2 parameters, first one is player's name, second - Bowling game object itself
4. To get fancy output into console, you have to do two steps:
  -  Create **ConsoleBowling** object
  -  call its method ***showFullPlayerTable*** with provided 2 parameters: name of player and list of all active score boards in a single game
  -  P.S *active score board* depends on player's number, for each player there is one personal score board

### :no_entry_sign:Restrictions
- If you don't add players, then you don't play!
- Only you (valid player) and your teammates can play, random person cannot play, since it hasn't payed for the game
- You cannot down more than 10 pins in a one frame
- Exception is for thrid frame, where you are asked to throw 3 rolls, instead of regular 2, however if thrid roll is redundant it is omitted by program


### :electric_plug:Try yourself
- [Clone it](https://github.com/ojacomarket/Bowling.git)
- Open it in IDE of interest
- Change branch to ***backend***
- Head over to **TietoBowling** class 
- Create new instance of ***Bowling Game*** and add your players
- You add them by calling ***init(names go here)***
- After you done, you are initialized in a system and can start **throwing balls** as you would do in real game
- By calling ***throwBall(roll1, roll2, who is throwing)*** you throw exactly ONE FRAME
- Where *roll1* = points for first roll, *roll2* = points for second roll, *who is throwing* = player's name
- Btw, you can throw as many times as you want, except you reach frame numbers of 10. Then game ends:x:

### :eyeglasses:Run unit tests to validate
12 Unit tests are there to validate API and its implementation. Despite the amount isn't biggest one , it is just impossible to test each combination
for that, you would have 1024 unit tests. In addition to Unit test, you also can [visit this amazing website](https://www.bowlinggenius.com/), where
you can put my code on test and see what it will output into a console score table.
