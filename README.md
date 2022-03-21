<h1 align="center">
 Maze Project
</h1>

We used the A* Algorithm to find the best path possible.

To win you some time, here are all the commands you need : 

## Build the image : 

```ps1
docker build -t maze-dorville-elarabi .
```

## Run the algorithm for the mazes : 

### Maze 1 : 

```ps1
docker run --name mazeDEA1 -e LAB=rect_01 maze-dorville-elarabi:latest
```

### Maze 2 (not working):

```ps1 
docker run --name mazeDEA2 -e LAB=rect_02 maze-dorville-elarabi:latest
```

### Maze 3 :

```ps1 
docker run --name mazeDEA3 -e LAB=rect_03 maze-dorville-elarabi:latest
```

### Maze 4 :

```ps1 
docker run --name mazeDEA4 -e LAB=rect_04 maze-dorville-elarabi:latest
```

### Maze 5 :

```ps1 
docker run --name mazeDEA5 -e LAB=rect_05 maze-dorville-elarabi:latest
```

## Delete all the containers : 

```ps1 
docker rm --force mazeDEA1, mazeDEA2, mazeDEA3, mazeDEA4, mazeDEA5
```

## Delete the image :

```ps1 
docker image rm maze-dorville-elarabi:latest
```
