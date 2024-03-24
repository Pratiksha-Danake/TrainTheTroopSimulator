## TrainTheTroopSimulator

### State And Behaviours

#### class Troop

- State
  - private String type
  - private String weapon
  - private int trainingTime
  - private int trainingCost

#### class Barrcaks : provide training service

- state
  - private final int size = 10
  - private List<Trooper> trainedTrooperList
- Behaviour
  - public void trainTheTroop()

##### NOTE : we can train only one troop at a time

#### class ArmyCamp

- state
  - private List<Trooper> trainedTrooper
- Behaviour
  - public void addTroop()
  - public showTroopCount()
