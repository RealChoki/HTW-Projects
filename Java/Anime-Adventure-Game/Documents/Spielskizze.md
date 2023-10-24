#### Spielskizze
## Theme: One Piece
Luffy, the best student of Hogwards, is on his journey to free his dad from the tyranny of the most evil wizard, the world has known - Arlong. Arlong has kidnapped several high-tier wizards, such as Monkey D. Dragon - Luffy's dad, using his blue haki spell "THE WATER!"

Eingabe: Anfang des Spiels/Login (Hauptmenu), Beim Angriff (welche Attacke), Nach dem Kampf (Gamemenu)
Wenn unerwünschte Eingabe, dann log out Error, und lass den Benutzer wiederwählen

Benutzer Eingabe = 1 to 6
# Hauptmenü: 
1. Start new game
2. Resume game
3. Load game
4. Save game
5. Delete game
6. Quit



# Klassen:
1. Magician:
- name: String
- spells: Spells[] (max.5)
- lifePoints: int 1000 
- Constructor(name)
- getLevel() = √exp 

magician is Luffy
also he will get attribute: GUM, so hes weak against slice, heat attacks



2. Spell:
- incantation: a phrase of ur spell
- dmg: int
- hitProbability: int/float
- level: int
- constructor()
- train() = (incantation.length) / (spell level + 1) * 1000 = ms (time that is needed to level up the spell)
** spell is going to be harder to level up, the higher the level of the spell **
** the player should see the spell and confirm that he's ready to type in the incantation to upgrade it. Enter to end **
Use StopWatch to measure time

also each spell will get its own attribute: to damage less or more depends on the opponents Attribute
Spells available: "ZA WINDA", "ZA CHESTA", "ZA WATER", "ZA WORLDO", "ZA DIARRHEA", "ZA CHEESEBURGA", "ZA MAGMA", "ZA ZA"


3. MasterWizard:
only static methods
- creates and returns a Magician
- teaches the magician a spell

MasterWizard is Silvers Rayleigh, the dark king, the right-hand man of the last King of Wizards - Gol D. Roger


4. Monster:
- name: String
- level: int
- lifePoints: (int) level*100
- attackDamage: (int level*50)

gets attributes


5. MagicGame:
- Constructor(player)


Benutzer Eingabe = 1 to 6
# Gamemenü:
1. Start adventure
2. Learn new spell
3. Improve spell
4. Show stats: Name, Lvl, HP, Balance, Spells(Name, hitProbability, lvl)
5. Take a rest: +100 HP but u lose -1 exp
6. Back to main menu


