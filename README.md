Air-Tactics-AI-Tester
=====================

- different AI strategies for Air Tactics are tested here


AI algorithms:
==============


RandomAI ~ 76 moves
-------------------

- shoots randomly on the board

SimpleAI ~ 75 moves
-------------------

- the same as RandomAI but avoids the corners

SmartRandomAI ~ 67 moves
-------------

- generates an initial probability matrix with each value representing the number of planes that can have their head on that tile

0 1 1 1 1 1 1 1 1 0 <br/>
1 2 2 3 3 3 3 2 2 1 <br/>
1 2 2 3 3 3 3 2 2 1 <br/>
1 3 3 4 4 4 4 3 3 1 <br/>
1 3 3 4 4 4 4 3 3 1 <br/>
1 3 3 4 4 4 4 3 3 1 <br/>
1 3 3 4 4 4 4 3 3 1 <br/>
1 2 2 3 3 3 3 2 2 1 <br/>
1 2 2 3 3 3 3 2 2 1 <br/>
0 1 1 1 1 1 1 1 1 0 <br/>


SmartAI ~ 21 moves
-------


