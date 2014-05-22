JGame
======================

Creating a small game, this readme will hold documentation on differant parts of the program in most likely a random order





save file config:

the save file has 3 parts, only one of which is sort of working right now,
The idea for the final save file is that it will first hold general data, player names, enemy names, teams, diplomacies, maybe fixed routes?, and more of that stuff.
Then there will be certain set of characters which notify the program that I am entering the part of the save file that holds the level.

this is the part that is currently roughly defined:

The first 2 bytes will hold the X coördinate, the third and fourth byte will hold the Y coördinate.
then there will be one byte that specifices the ground type (grass, sea, ocean, desert etc)
following by 1 byte that holds a so called player byte, this will be used in connection with the next byte:
the object byte, this can range from trees, gold mines, fishing areas, up till barracks, houses, walls, town centers, etc.
when a building is specified the player byte will have a value from 1 till 8 depending on the player, if the either is not an object, or the object is of nature, then the player byte will be 0.
it will then end with an objectPart byte, this byte will show which part of a multipart structure is at these coördinate. for example imagine a quarry of 3*3, then this byte might range from a value of 1 till 9, depending on which part of the object is here.
this byte will be used to keep track of for example orientation aswell as help with texturing.
Then there will be a final 9th and 10th bytes, this will be the metadata bytes.   the metadata bytes will only be defined for an object where the object part byte = 1.
this metadata depends on the object, for trees it can hold the amount of wood a certain tree still has, it can hold the HP of buildings, and whatever else I seem to need on the metadata. this may or may not be combined with the object part later

following is a small representation of the above mentioned format:

[x][x][y][y][g][p][o][op][m][m]

x = x coördinate,
y = y coördinate.
g = ground type.
p = player,
o = object,
op = object part,
m = metadata.