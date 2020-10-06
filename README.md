## Design and Implementation

#### Language and Framework

The language and framework I choose is Java and Spring Boot. It is one of the most famous and covenient tool developing RESTful API and can be easily applied to this assesment. Unfortunately I did not get a chance to implement the frontend yet, so for now we would have to use [Postman](https://www.postman.com/) to call and test our APIs. In addition, I'm going to run it as a Docker container to avoid potential complexity.

#### Overall Design

The project can be divided into two major classes. The Application class that handles all the API calls and the overheads, and the Inventory class that serves as the backend database and provides all the core functions.

Since we are not allowed to use any databases and the data set is approximately 50k in size. I only stored data in memory with Java collections such as ArrayLists and TreeSet as oppose to writing to a disk file. If our data set continues to grow in the future, we will need to start writing to disk files.

#### POST /api/products/autocomplete

Since this is a problem where the prefix order is the key element. I constructed three TreeSet\<String> each for product name, category, and brand when we first initialize the Inventory. This way we can take advantage of TreeSet's property and only need to find the sub-root node that contains all matching strings.

Space Complexity: **O(N)** as we still store all potential matching strings.

Time Complexity: **O(logN)** Since we store strings in Treeset, there are. at most logN levels.

#### POST /api/products/search

For this problem, I used Java's stream API and the filter function. Although this is a naive implementation and we still iterate over all entities, we still get results within reasonable time for our data set size. We might want to partition the data set and implement  some multithread solution if our data set grows tremendously.

Space Complexity: **O(N)** 

Time Complexity: **O(N)** 

#### POST /api/products/keywords

First I define a keyword as a word that has appeared in the **productName** field of the data. I do not consider words that are in other fields because other fields are more likely to use the search API where the productName field is more chaos than the others a search API might not work ideally. For this problem I constructed a HashMap<String, Integer> during initialization of the inventory, where I increment each word count as they show up in productName.

Space Complexity: **O(NM)** where M is the max number of words from producName field

Time Complexity: **O(NM)** for construction **O(1)** when called

## Instructions to Run

To run the SimpleAPI server, please run the following commands under the simpleapi directory.

```bash
docker build -t simple-api .
docker run -p 8088:8080 simple-api
```

Since I do not have a frontend yet. We can use Postman as of now. For example, to run the search API we add the following request to Postman.

```ba
http://localhost:8088/api/products/autocomplete
```

Body of Request:

```ba
{ "type": "brand", "prefix": "Can" }
```

Expected Response:

```bash
[
    "CandyHome",
    "Candyoo",
    "Cangshan",
    "Canless Air System",
    "Cannon Safe",
    "Canon",
    "Canonet",
    "Canopy",
    "Canyon Dancer"
]
```
