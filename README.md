
# Android CornerView

<h2>switch between two fragments from corner by dragging or on click.</h2>
 
 * Sample app :  [Pleague](https://github.com/ahmedmamdouh13/Pleague.git)
 
 </br>
 <img src="screencast-Genymotion-2020-02-23_03.48.18.811.gif" width="350" height="650" />
 </br>

 **Installing**
 
 Add it in your root build.gradle at the end of repositories:
 
  ```groovy
 	allprojects {
 		repositories {
 			...
 			maven { url 'https://jitpack.io' }
 		}
 	}
  ```
 	
 Step 2. Add the dependency
 
  ```groovy
  dependencies {
 		    implementation 'com.github.ahmedmamdouh13:CornerView:1.0'
 	}
  ```
 
 **How To Use It**
 
  * create your fragment instances
 ```kotlin
  val first = MatchesFragment()
  val second = FavoriteFragment()
 ``` 
 
  * add them to Controller fragment instance 
   
 ```kotlin
  val controller = Controller().apply {
      this.first = first
      this.second = second
  }            
 ``` 
 * add the collapsed icon of the first and second fragment
   
 ```kotlin
  controller.setFirstCollapseIcon(R.drawable.ic_list_black_24dp)
  controller.setSecondCollapseIcon(R.drawable.ic_favorite_black_24dp)
 ``` 
 * same for colors
 
 ```kotlin
  controller.setFirstCollapseColor(android.R.color.black)
  controller.setSecondCollapseColor(R.color.colorAccent)
 ``` 
 * add the Controller fragment to your layout
 
 ```kotlin
  supportFragmentManager.beginTransaction()
      .replace(
          R.id.main_container_mainactivity,
          controller, "Controller"
      ).commit()
 ```
* That's it :).
