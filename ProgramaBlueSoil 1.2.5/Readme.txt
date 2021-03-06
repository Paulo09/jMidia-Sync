##########################################################################
##                                                                      ##  
## For full using the powerful installation program, please read this.  ##
##                                       				##
## 	IVT BlueSoleil 1.6                                      	##
##	 for Windows 98/98SE/ME/2000/XP                                 ##
##	 Copyright 2004 IVT Corporation.                                ##
##	 All rights reserved.                                           ##
##########################################################################

■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
■
■ ▼ Silent Install.
■
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

▼1. Method A:
--------------------

For most of experienced users of BlueSoleil, it is not convenient to click many times 'next' button to finish
the installation of BlueSoleil. Therefore, you can now add the following to the setup.ini to skip
this process.

[SETUP]
NoDialogShowing=YES

Please remember that always change the parameter as following as well:

[Startup]
EnableLangDlg=N

▼2. Method B
--------------------

Use command line "setup -nodlg" to run this feature. Please remember having modifed the paramter:

[Startup]
EnableLangDlg=N

Otherwise, a language selection dialog will pop up.

■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
■
■ ▼ Install HID service switch.
■
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

IVT BlueSoleil add a new exciting feature of HID service support. It will install HID service by default. 
However, you can disable it by modifing the setup.ini file:

▼ 1. Install HID Service
[setup]
IsInstallHidService=Yes

▼ 2. Not Install HID service
[setup]
IsInstallHidService=No

■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
■
■ ▼ Add new type USB dongle. 
■
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

When you plug in a new type USB dongle, but BlueSoleil shows the message that no hardware is detected.
It means that the BlueSoleil can not support this hardware. May be you can solve this problem by adding
its PID&VID as following:
 
1. Please add PID&VID to <bluesoleil installation dest dir>\bttl.ini

[HW24]
ID=USB\VID_0123&PID_4567 
Type=Bluetooth USB Device
DLL=Driver\USB\btcusb.dll
DLLD=Driver\USB\btcusbd.dll
Inffile=Driver\USB\btcusb.inf
Manufacture=ABC
 
2. Add 1 for the value of NUM

[DEFAULT]
PORT=1
NUM=24		<-------- e.g. change from 23 to 24
DriverRt=
TL=HW


3. Please add to <windows\inf>\btcusb.inf

%ABC%=ABC

[ABC]
%DeviceDesc%=Btusb_DDI, USB\VID_0123&PID_4567
ABC="ABC"

Note:
---------------------------------------------
1. For the devices that IVT has not tested, IVT does not guarantee that it can run with BlueSoleil.
2. If manufactures want BlueSoleil to support their devices, it is suggested that the sample devices should be sent to IVT and IVT will test the hardware and add their PID&VID to BlueSoleil.

■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
■
■ ▼ Copy your files during the installation of BlueSoleil.
■
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

Please read copyfile.ini to do this.

■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
■
■ ▼ Change the AV profile parameter setting.
■
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■

Please read btav.ini to do this.







IVT Corporation
Nov 22, 2004
