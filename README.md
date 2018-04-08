# SimulatedAnnealingUsingPlayFairCypher
Continious Assessment relating to "Artificial Intelligence" module, Final Year of Hons Software Development

## Project URL : https://github.com/karlesleith/SimulatedAnnealingUsingPlayFairCypher


## How To Run
In the command line, go to the root directory of the project and type in..
**java -cp ./PlayFair.jar ie.gmit.sw.ai.CipherBreaker**

During this module, The project required for us is to develop a "CypherBreaker" program that is able to crack a PlayFair cypher using a process called "Simulated Annealing".

##PlayFair

The Playfair Cipher is a manual symmetric encryption cipher invented in 1854 by Charles Wheatstone, however it’s name and popularity came from the endorsement of Lord Playfair.

The Playfair cipher encrypts pairs of letters (digraphs), instead of single letters as is the case with simpler substitution ciphers such as the Caesar Cipher. Frequency analysis 
is still possible on the Playfair cipher, however it would be against 600 possible pairs of letters instead of 26 different possible letters. For this reason the Playfair cipher is much more secure 
than older substitution ciphers, and it’s use continued up until WWII.

The playfair cipher starts with creating a key table. The key table is a 5×5 
grid of letters that will act as the key for encrypting your plaintext. Each of the 25 letters must be unique and one l
etter of the alphabet (usually Q) is omitted from the table (as there are 25 spots and 26 letters in the alphabet).


##Simulated Annealing
Simulated annealing (SA) is a probabilistic technique for approximating the global optimum of a given function. Specifically, it is a heuristic to approximate global optimization 
in a large search space. It is often used when the search space is discrete (e.g., all tours that visit a given set of cities). For problems where finding an approximate global optimum is
 more important than finding a precise local optimum in a fixed amount of time, simulated annealing may be preferable to alternatives such as gradient descent.

