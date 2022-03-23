# ComponentFactory - Canvas
Heart Icon Using Canvas Api - Jetpack Compose

**Canvas**

The core composable for custom graphics is Canvas. You place the Canvas in your layout the same way you would with any other Compose UI element. Within the Canvas, you can draw elements with precise control over their style and location.

For More: [Canvas Api Documentation](https://developer.android.com/jetpack/compose/graphics)


 **By using, `FavouriteIcon()` composable we can draw Heart Icon**
   
 -  @param `modifier` we can provide size, padding etc
 -  @param `isSelected` which is used to identify Icon State
 -  @param `style` Two types of style you can apply from this two [Style.Fill], [Style.Stroke]. By default, [Style.Fill]
 -  @param `selectedColor` Color for Active State
 -  @param `unSelectedColor` Color for InActive State
 -  @param `shape` We can change Card Shape
 
 
```ruby
FavouriteIcon(
          modifier = Modifier.width(100.dp).height(100.dp),
          isSelected = isSelectedRounded.value,
          style = Style.Fill,
          selectedColor = Color.Green,
          unSelectedColor = Color.Red
        ) {
                isSelectedRounded.value = !isSelectedRounded.value
          }
```



https://user-images.githubusercontent.com/58662676/159714488-e0d24162-8262-4529-9bfa-554b005a8714.mov

