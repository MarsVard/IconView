## IconView

IconView is an extension of Android TextView class which provides support for a custom icon font
![screenshot](https://raw.github.com/MarsVard/IconView/master/screenshot.png)

## Usage

### Including in your project
	
IconView is presented as an [Android library project](http://developer.android.com/guide/developing/projects/projects-eclipse.html). 
It is not a standalone JAR because fonts are stored as a raw resources.

You can include this project by [referencing it as a library project](http://developer.android.com/guide/developing/projects/projects-eclipse.html#ReferencingLibraryProject) in Eclipse or ant.

add the following line to the root element of your layout

```xml
xmlns:iconview="http://schemas.android.com/apk/res-auto"
```

### Sample usage
**Layout:**
```xml
<be.webelite.iconview.IconView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    iconview:icon_name="entypo_search"
    android:textSize="25dp"/>
```

## in code usage
```java

IconView myfavicon = (IconView)findViewById(R.id.my_favorite_view);
myfavicon.setIcon(Icon.entypo_airplane);

```
## Available fonts
	
the entypo font is loaded out of the box, you can add your own font by creating a package at http://icomoon.io
the reason for not using the icofonts as supplied by ex. www.entypo.com is that the have unicode values used by the fonts are too long and not supported by android.

##creating your own font pack

 * go to icomoon.io
 * create a fontpack
 * download the font pack
 * include the ttf file in res/raw
 * replace enum types in res/values/attr.xml with the ones in the style.css given to you by icomoon.io (some manual search&replace action will help you).
 * ?????
 * PROFIT

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

**Note that all fonts have their own license.**