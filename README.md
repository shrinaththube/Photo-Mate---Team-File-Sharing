# Photo-Mate---Team-File-Sharing
Inter Domain Photo sharing application

This is academic project for CMPE 207 Soket Programming course.

Aim of the project was to develop a inter domain photo sharing application in which user upload the photo on his/her own server and this photo
will upoladed to other four server by using CURL.We took 5 different web hosting solutions. Wrote server side in PHP. 
We developed 2 clients (Java based client and Web based client).

This git project is Java based client that has functionality of uploding the photo on web hosting server by making soket connection.
This client has following functionality.  
!) Authentication - User needs to login to upload the photos.  
!!) Drag and drop - User can upload multiple photos by draging and droping.  
!!!) View the list of photos - Java client makes the FTP connection to server and show the list of uploaded files on server.  
!V) Download the photos -  User can view and download photos uploaded by all team members.  

Source code is in src/filesharingjava directory  
!) LoginDialog.java - This is starting code that checks the authentication of user by making connection with server. Server checks it's 
databse to find user.  
!!) Dropper.java - This handdles Drag and drop functionality  
!!!) MyFileTransferHandler.java - This makes connection to server and transfer file.  
