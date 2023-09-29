Anstatt dass der Player bei Level 5 gewinnt, musst er Endboss besiegen, um zu gewinnen.

Die Mosters nutzen auch Spells, aber deren Damage Output inkrementiert mit deren Level. 
Also Damage Output =  (level * 50) + Spell Damage

Bei Spells werden die Damage erstmal hardcoded, aber nachdem Train() methode aufgerufen wird, wird der dmg so inkrementiert:
Spell damage = Spell damage + (Spell level * 5);
