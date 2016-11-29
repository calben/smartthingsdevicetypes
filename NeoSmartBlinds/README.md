# Using your Neo Smart Blinds product with Samsung Smartthings

## Introduction

A Neo Smart Blinds Controller can interface with a Samsung Smart Things Hub, enabling you to use your SmartThings phone app or scripts such as "Good Morning" to control your blinds.


## Ensuring Your Blinds Are Ready for Smartthings


## Downloading and Installing the Device Handler

1. Open the Device Type Handler code from [this link](https://raw.githubusercontent.com/calben/smartthingsdevicetypes/master/NeoSmartBlinds/neosmartblind.groovy).  You're going to paste this code later, so either go ahead and copy it or leave it open on another browser tab.
1. Navigate to device type handlers in your SmartThings dashboard.
    1. Open your Smartthings dashboard at [graph.api.smartthings.com](https://graph.api.smartthings.com/).
    1. Once your dashboard is open, there is a menu at the top that includes Locations, Hubs, Devices, etc.  From this menu, select `Device Handlers`.
1. Install the device type
    1. If you've already installed a device handler before, you'll be presented with those handlers, but if you're new to installing device handlers you should be presented with a blank list or a page that says "Let's Get Started."  On this page there will be a `Create a New Device Handler` button.  Select it to enter the new device handler form.
    1. You will be presented with many options, but select `From Code`, as in the picture.
    1. Paste the code you copied! 
    1. Select the `Create` button.
    1. You've now installed the Neo Smart Blinds controller device type!
1. Publish the device type for yourself.
    1. On your device handler's page, navigate to the device handler options bar and select `Publish`.
    1. You may have multiple options here, but most likely you will only be presented with `For me`.  Selected `For me` to push your device type handler to your hub and your phone.
1. Make a Neo Smart Blind device!
    1. In the top menu of the SmartThings dashboard is `Devices`.  Select it to create a virtual device.
    1. Select `New Device`.
    1. Enter device parameters.  These are largely up to the user, but make sure to choose "Neo Smart Blind" as your device type.  Note: "Neo Smart Blind" might be at the very bottom.  
1. Set up the device on your phone.
    1. Navigate to "Things" on your phone.