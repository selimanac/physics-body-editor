
# Physics Body Editor

Physics Body Editor is originally developed by [Aurelien Ribon](http://www.aurelienribon.com/) and maintained by [MovingBlocks](http://terasology.org) for libGDX loader.

This is the modified version for Defold Game Engine compatibility. I made a lots of breaking changes, improvements, added new functionalities and bug fixes.

Generic file format is json. It is simple to read and can be implemented in any game engine.

More info and manual is available here: https://selimanac.github.io/physics-body-editor/

### Release Notes

#### 1.5.0

- New GUI color schema
- New coordinate system
- New zoom level and pivot(origin) functionallties
- Defold Exporter with .convexshapes and .go files
- Lots of small bug fixed


### Known issues

- Incorrect Layout Rendering of LwjglCanvas on MacOS [#5004](https://github.com/libgdx/libgdx/issues/5004)
- Multi-part Detection and Hole Detection are not working as aspected. They are disabled. Need more investigation.
- Swing widget toolkit is ancient and it is not supporting anymore. So it may contain bugs.  





   

     
