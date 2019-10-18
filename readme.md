![Physics Body Editor](https://selimanac.github.io/physics-body-editor/img/git_header.png)

Physics Body Editor is originally developed by [Aurelien Ribon](http://www.aurelienribon.com/) and maintained by [MovingBlocks](http://terasology.org) for libGDX loader, also they added the Gradle build support.

This is the modified version for Defold Game Engine compatibility. I made a lot of breaking changes, improvements, added new functionalities and bug fixes.

More info and manual is available here: https://selimanac.github.io/physics-body-editor/


![Physics Body Editor](https://selimanac.github.io/physics-body-editor/img/screen.png)



### Release Notes

#### 1.5.0

- All dependencies updated.
- New dark theme GUI color schema.
- New coordinate system.
- New zoom level and pivot(origin) functionallties.
- Defold Exporter with .convexshapes and .go files.
- Lots of major & minor bugs fixed.

### Build

> $ gradle init  
> $ gradle jar


### Known issues

- Incorrect Layout Rendering of LwjglCanvas on MacOS. [#5004](https://github.com/libgdx/libgdx/issues/5004) Temporarily fixed with glue.
- Multi-part Detection and Hole Detection are not working as expected. I disabled them. Require more investigation on the issue.
- Swing widget toolkit is ancient and it is not supported anymore. So it may contain non fixed bugs.





   

     
