# Securing Health Records Stored On Cloud

## Introduction
This project is about enhancing the security of files stored on cloud. 
To achieve higher security we follow a three step process:
1. Health record file is divided into multiple parts.
2. Each part is encrypted using AES algorithm.
3. Each part is stored in random buckets on AWS S3.

## Features
 - Simple user interface for admin, doctor and patient.
 - Admin can view, add and modify doctor or patient.
 - Doctor can add, view patient details.
 - Doctor can request for patient report download and can download only with patient OTP. 
 - OTP Consent Mechanism for security.
 - Patient can upload report, view his medical history.
 - Files are split into multiple chunks of data, encrypted and then stored on cloud.
 - During download, the parts of file are decrypted and merged.

This project uses the concept of blockchain at the backend as it stores the data <br>
in blocks and the blocks are distributed randomly on the cloud storage buckets.

## Output and working demo
![Screenshot (786)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/4dc6a0d0-b888-427c-9d49-bc2ad8c9ec71)
![Screenshot (788)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/01d526d1-a29e-4a0f-a625-5928aa84d67b)
![Screenshot (791)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/1ce65e8b-16df-46c7-8541-c61d4527e9cc)
![Screenshot 2024-04-22 132450](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/2f1ca2b8-b960-471e-9f1f-75338d8f379b)
![Screenshot (792)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/bf90b122-0920-4e0d-b76b-c09292490dbd)
![Screenshot (793)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/79d89dde-bdda-4efa-a1e3-21b46e008d48)
![Screenshot (794)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/b24025ad-872d-48b8-b335-247afbbd9001)
![Screenshot (795)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/132a2925-6f0a-4790-b3db-b9a6ed5b391d)
![Screenshot (796)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/946771e6-9f13-428f-80e6-a62a65576a5b)
![Screenshot (797)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/62ee01f7-e13e-426e-8528-6907f7f74a1b)
![Screenshot (798)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/70a77daa-8fa2-4f91-b7fa-7b1a70ece77d)
![Screenshot 2024-04-22 132700](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/5815c949-6799-4f57-b5ed-7291b8c0eeaf)
![Screenshot (799)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/30a8688a-0eeb-40fc-a436-d59993b86c54)
![Screenshot (800)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/c50841b4-3cc1-4eb3-a8b4-e10d6ccf32ca)
![Screenshot (801)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/7c638963-d423-43ee-a6ce-23979dbbc6fb)
![Screenshot (802)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/1660d3b8-ebed-4db8-96a5-a634cdb4730a)
![Screenshot (804)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/45a25eca-20de-457f-a03e-188eccfdc12f)
![Screenshot (806)](https://github.com/swanandtamaskar1/securing-health-records-stored-on-cloud/assets/35898035/628c8cc7-f19f-4b7c-ac33-b8974463ceec)





