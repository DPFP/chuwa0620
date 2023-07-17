# API Design
## 1.Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- �����淶
users��orders

## 2.Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
GET - ��ȡ����������Ϣ��

GET /api/posts����ȡ���в������µ��б�
GET /api/posts/{id}�����ݲ������µ�ID��ȡ�ض��Ĳ���������Ϣ��
POST - �����µĲ������£�

POST /api/posts������һƪ�µĲ������¡�
PUT - ���²���������Ϣ��

PUT /api/posts/{id}�����ݲ������µ�ID�����ض��Ĳ���������Ϣ��
DELETE - ɾ���������£�

DELETE /api/posts/{id}�����ݲ������µ�IDɾ���ض��Ĳ������¡�

## Design APIs for the following features (˼����path variable ��ô�ã���sub resources, ��Щ�ط����ø���)

���ҿͻ���֧����ʽ�������ÿ�1�����ÿ�2��PayPal��Apple Pay��

GET /api/customers/{customerId}/payments�������ض��ͻ�������֧����ʽ��
GET /api/customers/{customerId}/payments/{paymentId}�������ض��ͻ����ض�֧����ʽ��
���ҿͻ���2023��7��10�յ�2023��7��13���ڼ����ʷ������

GET /api/customers/{customerId}/orders?startDate=2023-7-10&endDate=2023-7-13�������ض��ͻ���ָ�����ڷ�Χ�ڵ���ʷ������
���ҿͻ����ͻ���ַ��

GET /api/customers/{customerId}/addresses�������ض��ͻ��������ͻ���ַ��
GET /api/customers/{customerId}/addresses/{addressId}�������ض��ͻ����ض��ͻ���ַ��
����������ȡ�ͻ���Ĭ��֧����ʽ��Ĭ���ͻ���ַ�������������API��

GET /api/customers/{customerId}/default-payment����ȡ�ض��ͻ���Ĭ��֧����ʽ��
GET /api/customers/{customerId}/default-address����ȡ�ض��ͻ���Ĭ���ͻ���ַ��