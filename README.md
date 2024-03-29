<h1 align="center">
 Maze Project
</h1>

We used the A* Algorithm to find the best path possible.

To win you some time, here are all the commands you need : 

# Pull from Docker-Hub
```ps1
docker pull adanea/maze-dorville-elarabi
```
## OR
# Clone and Build the image :
```ps1
docker build -t adanea/maze-dorville-elarabi .
```


# Run the algorithm for the mazes : 

### Ovale Maze 1 :

```ps1
docker run --name mazeDEAO1 -e LAB=oval_01 adanea/maze-dorville-elarabi:latest
```

### Maze 1 : 

```ps1
docker run --name mazeDEA1 -e LAB=rect_01 adanea/maze-dorville-elarabi:latest
```

### Maze 2:

```ps1 
docker run --name mazeDEA2 -e LAB=rect_02 adanea/maze-dorville-elarabi:latest
```

### Maze 3 :

```ps1 
docker run --name mazeDEA3 -e LAB=rect_03 adanea/maze-dorville-elarabi:latest
```

### Maze 4 :

```ps1 
docker run --name mazeDEA4 -e LAB=rect_04 adanea/maze-dorville-elarabi:latest
```

### Maze 5 :

```ps1 
docker run --name mazeDEA5 -e LAB=rect_05 adanea/maze-dorville-elarabi:latest
```

# Add your own maze
To add another maze :
* You MUST add it in the ``resources`` file 
* You MUST have the extension .map.txt in your file (e.g: ``myAmazingMaze.map.txt``)
* When creating a new container make sure to put ONLY the name of your maze and not the `.map.txt` extension as an env variable (e.g `LAB=myAmazingMaze`)
* Enjoy our marvelous A* Algorithm

# Delete all the containers : 

```ps1 
docker rm --force mazeDEAO1, mazeDEA1, mazeDEA2, mazeDEA3, mazeDEA4, mazeDEA5
```

# Delete the image :

```ps1 
docker image rm adanea/maze-dorville-elarabi:latest
```
