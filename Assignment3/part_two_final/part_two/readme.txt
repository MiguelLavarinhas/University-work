# SimulatorTwo

SimulatorTwo is a java program which prints paths from taxi to client and from client to shop where the taxi is of the same company as the shop.


## Usage

# input 1:
5
0 4 15
1 0 14 2 7 3 23
2 0 7
3 1 23 4 16
4 2 15 3 9
2
0 TR&G 3 NM&G
3
1 4 2

# explanation:
In line(0 TR&G 3 NM&G) the shops 0 and 3 each have a string afterwards. The first character of the string decides whether there is a taxi stationed at the shop as in this program there are a finite amount of taxis and not every shop has a taxi. This is implemented by showing that there is a taxi by putting a "T" as the first character or "N" for no taxi. The second part is the company name of the shop and taxi if there is a taxi at the shop.

#returns 

client 1
taxi 0 R&G
0 4 3 1
shop 0 R&G
multiple solutions cost 14
client 4
taxi 0 R&G
0 4
shop 0 R&G
4 2 0
client 2
taxi 0 R&G
0 4 2
shop 0 R&G
2 0

#explanation:
The program prints which taxi picks up the customer and the company it belongs to. In this scenario if there was a taxi stationed at shop 3 it would have picked up clients but the user input that there is no taxi at shop 3. The program also only allows taxis to take clients to shops of the same company as the taxi.

# input 2:
5
0 4 15
1 0 14 2 7 3 23
2 0 7
3 1 23 4 16
4 2 15 3 9
2
0 TR&G 3 TM&G
3
1 4 2

#returns

client 1
taxi 3 M&G
3 1
shop 3 M&G
1 3
client 4
taxi 0 R&G
0 4
shop 0 R&G
4 2 0
client 2
taxi 0 R&G
0 4 2
taxi 3 M&G
3 1 2
shop 3 M&G
2 0 4 3

#Explanation:
This input example shows the output when there are multiple taxis with different companies.

