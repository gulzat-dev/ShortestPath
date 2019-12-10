# ShortestPath
INPUT FILE FORMAT(LOOK CONF.TXT)
- Input: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7*
- 1: A-B-C
- 2: A-D
- 3: A-D-C
- 4: A-E-B-C-D
- 5: A-E-D
- 6: C C 3
- 7: A C 4
- 8: A C
- 9: B B

### Output 
- 1# 9
- 2# 5
- 3# 13
- 4# 22
- 5# NO SUCH ROUTE
- 6# 2
- 7# 3
- 8# 9
- 9# 9

- command 1 - 5  find distance of route
- command 6,7 The number of trips starting at "C" and ending at "C "with a maximum of 3 stops
- command 8 The length of the shortest route from source to another point
- command 9 The length of the shortest route from source to source
