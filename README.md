## TrainTheTroopSimulator

![Jacoco Test Report](/TTT-JTR.png)
![Output](/TTT-OP.png)

Problem Statement :
Problem Statement: (Troop training simulation is inspired from Clash of Clans games.)
As a gaming programmer you have to create a simulation software using which gamers can train army troops.
Definition and details of the simulation is as follows

## Trooper Training Details

| Trooper Type | Weapon        | Training Time (seconds) | Training Cost (magic potions) |
| ------------ | ------------- | ----------------------- | ----------------------------- |
| Barbarian    | Sword         | 3                       | 10                            |
| Archer       | Bow and Arrow | 6                       | 20                            |

Barracks: where each trooper gets trained.
Only one trooper can be trained at a given point of time.
The maximum seat capacity of a barracks is 10.
Others have to wait to outside the barracks
Barracks can have mix of troopers: e.g.: 5 Archers and 5 Barbarians or 4 Archers and 6 Barbarians or 10 Archers or 10 Barbarians
Army Camp: where troops assemble after training.
Scenario 1: Simulate the training and train barbarians and/or archers.
As a gamer

1. i should be able to input no.of barbarians and/or archers i would like to train.
2. i should be able to see how many troops are trained and available in troop camp after training completes.
   Example input/output:

troop-training > start-training

1. train troops.
2. view troop camp
   What do you want to do ? 1

3. Archer
4. Barbarian
   which troop u want to train ? 1
   how many archers you want to train ? 10
   training...
   training complete. troops are available in the troop camp.

5. train troops.
6. view troop camp
   What do you want to do ? 2
   Archers: 10
   Barbarian: 0

7. train troops.
8. view troop camp
   What do you want to do ? 1

## OOMD Solution :

## Package `com.amaap.trainthetroop.domain.model.entity`

## Class `Trooper`

**Attributes:**

- `int trainingTime`
- `int trainingCost`
- `String weapon`

**Behaviors:**

- `public Trooper(int trainingTime, int trainingCost, String weapon) throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException`
- `public int getTrainingTime()`
- `@Override public boolean equals(Object o)`
- `@Override public int hashCode()`

**Exceptions:**

- `InvalidTrainingTimeException`: Thrown when the training time is zero or less.
- `InvalidTrainingCostException`: Thrown when the training cost is zero or less.
- `InvalidTrooperWeaponException`: Thrown when the weapon is null or empty.

## Class `Archer`

**Attributes:**

- Inherits all attributes from `Trooper`

**Behaviors:**

- `public Archer(int trainingTime, int trainingCost, String weapon) throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException`

## Class `Barbarian`

**Attributes:**

- Inherits all attributes from `Trooper`

**Behaviors:**

- `public Barbarian(int trainingTime, int trainingCost, String weapon) throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException`

## Package `com.amaap.trainthetroop.domain.model.entity.exception`

## Class `InvalidTrainingTimeException`

## Class `InvalidTrainingCostException`

## Class `InvalidTrooperWeaponException`

## Package `com.amaap.trainthetroop.domain.model.entity.validator`

## Validator Methods

**Behaviors:**

- `public static boolean isInValidTime(int trainingTime)`
- `public static boolean isInvalidTrainingCost(int trainingCost)`
- `public static boolean isInValidWeapon(String weapon)`

## Package `com.amaap.trainthetroop.controller.dto`

## Class `Response`

**Attributes:**

- `private final HttpStatus httpStatus`: Represents the HTTP status of the response.
- `private final String message`: Represents the message of the response.

**Behaviors:**

- `public Response(HttpStatus httpStatus, String message)`: Constructor to initialize the `httpStatus` and `message`.
- `@Override public boolean equals(Object o)`: Checks if the current object is equal to another object.
- `@Override public int hashCode()`: Returns the hash code value for the object.

## Package `com.amaap.trainthetroop.controller.valueobject`

## Enum `HttpStatus`

**Values:**

- `OK`: Indicates the request was successful.
- `BAD_REQUEST`: Indicates the request is invalid.

# Documentation for `com.amaap.trainthetroop`

## Package `com.amaap.trainthetroop.controller`

## Class `TrooperController`

**Attributes:**

- `private final TrooperService trooperService`

**Behaviors:**

- `@Inject public TrooperController(TrooperService trooperService)`: Constructor that injects the `TrooperService`.
- `public Response createTrooper(Troop type, int trainingTime, int trainingCost, String weapon)`: Creates a trooper and returns a response.
- `public List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount)`: Retrieves a list of troopers based on counts.

## Class `ArmyCampController`

**Attributes:**

- `private final ArmyCampService armyCampService`

**Behaviors:**

- `@Inject public ArmyCampController(ArmyCampService armyCampService)`: Constructor that injects the `ArmyCampService`.
- `public void addTroopToCamp(Trooper trooper)`: Adds a trooper to the camp.
- `public List<Trooper> getTroopers()`: Retrieves a list of troopers.
- `public int getCountOfTrooper(Troop troop)`: Gets the count of a specific type of trooper.

## Class `BarracksController`

**Attributes:**

- `private final BarracksService barracksService`

**Behaviors:**

- `@Inject public BarracksController(BarracksService barracksService)`: Constructor that injects the `BarracksService`.
- `public Response addTroopersToBarrack(int archerCount, int barbarianCount)`: Adds troopers to the barrack and returns a response.
- `public void trainTheTroop() throws InterruptedException`: Trains the troop.

## Package `com.amaap.trainthetroop.domain.service`

## Class `BarracksService`

**Attributes:**

- `private final BarracksRepository barrackRepository`: Repository to manage barracks data.
- `private final TrooperService trooperService`: Service to manage trooper-related operations.
- `private final ArmyCampService armyCampService`: Service to manage army camp operations.
- `Queue<Trooper> waitingTroopers = new LinkedList<>()`: Queue to manage waiting troopers.

**Behaviors:**

- `@Inject public BarracksService(BarracksRepository barrackRepository, TrooperService trooperService, ArmyCampService armyCampService)`: Constructor that injects the dependencies.
- `public Queue<Trooper> addTroopersToBarrack(int archerCount, int barbarianCount) throws TrooperLimitExceededException`: Adds troopers to the barrack and returns the updated queue.
- `public synchronized void trainTheTroop() throws InterruptedException`: Trains the troopers in the queue.

## Package `com.amaap.trainthetroop.domain.service.exception`

## Class `TrooperLimitExceededException`

**Attributes:**

- Inherits all attributes from `Throwable`

**Behaviors:**

- `public TrooperLimitExceededException(String message)`: Constructor that accepts a message to describe the exception.

## Package `com.amaap.trainthetroop.service`

## Class `ArmyCampService`

**Attributes:**

- `private final ArmyCampRepository armyCampRepository`: Repository to manage army camp data.

**Behaviors:**

- `@Inject public ArmyCampService(ArmyCampRepository armyCampRepository)`: Constructor that injects the `ArmyCampRepository`.
- `public String addTroopToCamp(Trooper trooper)`: Adds a trooper to the army camp and returns a message indicating success or failure.
- `public List<Trooper> getTroopers()`: Retrieves a list of troopers from the army camp.
- `public int getCountOfTrooper(Troop troop)`: Gets the count of troopers of a specific type from the army camp.

## Class `TrooperService`

**Attributes:**

- `private final TrooperRepository trooperRepository`: Repository to manage trooper-related data.

**Behaviors:**

- `@Inject public TrooperService(TrooperRepository trooperRepository)`: Constructor that injects the `TrooperRepository`.
- `public Trooper createTrooper(Troop type, int trainingTime, int trainingCost, String weapon) throws InvalidTrainingTimeException, InvalidTrainingCostException, InvalidTrooperWeaponException`: Creates a trooper of the specified type with the given attributes.
- `public List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount)`: Retrieves a list of troopers based on the specified counts of archers and barbarians.

## Class `InMemoryArmyCampRepository`

**Attributes:**

- `private final InMemoryDatabase inMemoryDatabase`: Database instance for storing army camp data.

**Behaviors:**

- `@Inject public InMemoryArmyCampRepository(InMemoryDatabase inMemoryDatabase)`: Constructor that injects the `InMemoryDatabase`.
- `@Override public String addToCamp(Trooper trooper)`: Adds a trooper to the army camp.
- `@Override public List<Trooper> getTroopers()`: Retrieves a list of troopers from the army camp.
- `@Override public int getCountOfTrooper(Troop troop)`: Gets the count of troopers of a specific type from the army camp.

## Class `InMemoryBarracksRepository`

**Attributes:**

- `private final InMemoryDatabase inMemoryDatabase`: Database instance for storing barracks data.

**Behaviors:**

- `@Inject public InMemoryBarracksRepository(InMemoryDatabase inMemoryDatabase)`: Constructor that injects the `InMemoryDatabase`.
- `@Override public Queue<Trooper> addTroopersToBarracks(List<Trooper> troopers)`: Adds troopers to the barracks.
- `@Override public Queue<Trooper> getTroopersInWaitingQueueToTrain()`: Retrieves troopers from the waiting queue in the barracks.

## Class `InMemoryTrooperRepository`

**Attributes:**

- `private final InMemoryDatabase inMemoryDatabase`: Database instance for storing trooper data.

**Behaviors:**

- `@Inject public InMemoryTrooperRepository(InMemoryDatabase inMemoryDatabase)`: Constructor that injects the `InMemoryDatabase`.
- `@Override public Trooper addTrooper(Trooper trooper)`: Adds a trooper to the repository.
- `@Override public List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount)`: Retrieves a list of troopers based on the specified counts of archers and barbarians.

## Package `com.amaap.trainthetroop.repository`

## Interface `ArmyCampRepository`

**Behaviors:**

- `String addToCamp(Trooper trooper)`: Adds a trooper to the army camp and returns a message indicating success or failure.
- `List<Trooper> getTroopers()`: Retrieves a list of troopers from the army camp.
- `int getCountOfTrooper(Troop troop)`: Gets the count of troopers of a specific type from the army camp.

## Interface `BarracksRepository`

**Behaviors:**

- `Queue<Trooper> addTroopersToBarracks(List<Trooper> troopers)`: Adds troopers to the barracks and returns the updated queue.
- `Queue<Trooper> getTroopersInWaitingQueueToTrain()`: Retrieves troopers from the waiting queue in the barracks.

## Interface `TrooperRepository`

**Behaviors:**

- `Trooper addTrooper(Trooper trooperToAdd)`: Adds a trooper to the repository and returns the added trooper.
- `List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount)`: Retrieves a list of troopers based on the specified counts of archers and barbarians.

## Package `com.amaap.trainthetroop.repository.db`

## Interface `InMemoryDatabase`

**Behaviors:**

- `Trooper addTrooper(Trooper trooper)`: Adds a trooper to the database.
- `List<Trooper> getTroopersOfCount(int archerCount, int barbarianCount)`: Retrieves a list of troopers based on the specified counts of archers and barbarians.
- `Queue<Trooper> addTroopersToBarrack(List<Trooper> troopers)`: Adds troopers to the barracks and returns the updated queue.
- `Queue<Trooper> getTroopersFromBarracks()`: Retrieves troopers from the barracks.
- `String addToCamp(Trooper trooper)`: Adds a trooper to the army camp and returns a message indicating success.
- `List<Trooper> getTroopersFromCamp()`: Retrieves troopers from the army camp.
- `int getCountOfTrooper(Troop troop)`: Gets the count of troopers of a specific type from the army camp.

## Class `FakeInMemoryDatabase`

**Attributes:**

- `private final List<Trooper> troopers`: List to store troopers.
- `private final Queue<Trooper> barracks`: Queue to store troopers in the barracks.
- `private final List<Trooper> armyCampTroopers`: List to store troopers in the army camp.

**Behaviors:**

- Provides implementation for all the behaviours declared in InMemoryDatabase class.
