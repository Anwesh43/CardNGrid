## CardNGrid

### Simple android module to create a listview of cards arranged in a vertical list which can be converted into a listview of cards arranged in a grid.


### Usage

#### Adding dependency in app/build.gradle

```
    dependencies {
        compile project(':cardngridlist')
    }
```

#### Adding a CardNGrid object in Activity

```
    CardNGrid cardNGrid = new CardNGrid(this);
```

#### Adding a card by passing a bitmap ,string and onClickListener

```
    cardNGrid.addCard(bitmap,title,new OnClickListener() {
        public void onClick() {
            //do your stuff here
        }
    });
```

#### Showing the View

```
    cardNGrid.show();
```
