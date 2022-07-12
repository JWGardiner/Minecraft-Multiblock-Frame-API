# Minecraft-Multiblock-Frame-API
An api for creating a multi-block frame structure for Minecraft fabric/quilt.

This works similarly to portals, where you can create a frame then light it, and it fills with portal blocks, however it's up to the developer what it fills with and what triggers it.

This is split into 3 parts:

- The frame (optional)
- The controller (can be used as a frame
- The fill block

The frame/controller make up the frame, you can use controllers as frames but you only need one, the controller is what triggers it so it's non-optional.

The fill block is what fills it. You have 2 config options for this; you can set it to either fill it and replace all blocks, or only fill when there's **no blocks** (Not including air, of course).

As the controller is a blockEntity, lots of frames made of the controller may lag more than creating a frame.

## Documentation
Once the API is complete, the documentation will be on the wiki tab, as well as an example.

## Build

If you want to build this API, you can just use `./gradlew build`

The main branch is the latest stable version, if you are looking for a specific version of Minecraft, look for the corresponding branch.

I will try and maintain all versions 1.18.2+, however support forever is not guaranteed (I will probably discontinue the 1.18.2 version when 1.20 has been released)

## Support

If you like what I do, you can [buy me a coffee](https://ko-fi.com/JWGardiner) or click the support link on the right.

All support helps, no matter how small!
