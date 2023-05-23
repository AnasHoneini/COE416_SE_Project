**COE416_SE_Project**

**School Guard**

This project aims to promote safety and prevent violence in schools by developing software capable of recognizing students who engage in aggressive behavior. The software utilizes machine learning algorithms for fight detection and facial recognition to identify and address violent acts committed by students in schools. A mobile application has been developed to enable school administrators and parents to monitor student safety and receive alerts in case of any violent incidents involving their children. The software includes a database for storing facial images used in the face recognition process, as well as storing the names of the students.

****Features****
The main features of the software include:

**Fight Detection:** The software implements a deep learning model for detecting violence or any type of fight in videos. It utilizes a pre-trained VGG19 convolutional neural network (CNN) as a feature extractor and a Long-Short-Term-Memory (LSTM) neural network as a classifier. The model is trained on the ImageNet dataset, which consists of around 14.2 million images organized according to the WordNet hierarchy. It functions as a binary classifier to predict the presence or absence of violence in videos.

**Facial Recognition:** The software incorporates facial recognition technology to identify students involved in violent incidents. It utilizes machine learning algorithms to analyze and match facial features extracted from stored images with real-time video footage. This enables the system to identify individuals engaged in aggressive behavior.

**Mobile Application:** The software includes a mobile application developed using Android Studio and Kotlin as the logic language. The mobile app provides a user-friendly interface for school administrators and parents to monitor student safety. It allows them to view real-time video feeds, receive alerts in case of any violent incidents involving their children, and access the database of stored facial images for identification purposes.

**Alert System:** The software is equipped with an alert system that sends immediate notifications to school administrators and parents when any violent incidents or fights are detected. This ensures swift response and intervention to prevent further escalation.

