

### �߳�״̬
![img_1.png](img_1.png)
### Synchronized 

    synchronized�ĵײ�ʵ��/��α�֤ԭ���ԡ������ԺͿɼ���
    ��
    �����Ƕ����Ǵ��룬 ���������Ϣ����ڶ���ͷMark Word(����ͷ)��
    ����ȡ��ʱ��ͨ��Monitorenterָ��(ͬ������飬ͬ����������Acc_synchronized��Ƿ����������ͷ�)��Monitor���м����������������߳��޷������
    ֱ�����д���ִ������ͨ��Monitorexitָ���ͷ���
    
    �������ԣ� ����ִ�е�˳���մ�����Ⱥ�˳��ִ��  �ɼ��ԣ�ִ����ɺ����н���������֮ǰ��������ͬ���������У���֤�����߳̿ɼ���
    
    �������ĸ�� ƫ����->������(��������)->��������
    ���̣�
    markword������ͷ�� ��¼����߳�ID ��Ϊƫ������
    ����߳����ã�����Ϊ ������
    Ĭ������10���Ժ�  ����Ϊ�������� - OS
    
    ��ͨ����������֪����ִ��ʱ��̣��������룩���߳����٣�������
                     ִ��ʱ�䳤���߳����࣬��ϵͳ��



![img.png](img.png)

### Volatile [?v?l?ta?l]

    ��֤�߳̿ɼ��ԣ�����һ����Э�飩
    ��ָֹ��������

### ����JUCͬ���� (c_20)
    ReentrantLock
    CountDownLatch
    CycliBarrier
    Phaser
    ReadWriteLock
    Semaphore
    Exchanger
    LockSupport

###  ������Ŀ��ʵ��������add,size...  (c_20)

![img_4.png](img_4.png)

### AQS ��c_20)
 1. AQSԴ��


### ǿ������  ��c_22)

![img_3.png](img_3.png)
![img_2.png](img_2.png)


### ThreadLocal ��c_22)
1. ThreadLocalԴ��
2. ThreadLocal��;�� ����ʽ�����籣֤һ��Connection


### ����
![img_5.png](img_5.png)
![img_7.png](img_7.png)
![img_6.png](img_6.png)


### �������ر��Ƕ��̸߲߳�����  ��c_25)

![img_8.png](img_8.png)
![img_9.png](img_9.png)
List
* CopyOnWriteList
* Vector
* ArrayList
* LinkedList

Set
* HashSet,LinkedHashSet
* SortedSet ,TreeSet
* EnumSet
* CopyOnWriteArraySet
* ConcurrentSkipListSet

Queue
* ����������
  * PriorityQueue �������ȼ����޽����ȼ�����
  * ConcurrentLinkedQueue ����˫������ṹ���޽粢������
* ��������
  * Deque ArrayDeque,BlockingDeque,LinkedBlockingDeque
  * BlockingDeque
      * ArrayBlockingQueue  һ��������֧�ֵ��н���С�
      * PriorityBlockingQueue  �������ȼ���֧�ֵ��޽����ȼ�����
      * LinkedBlockingQueue  һ�������ӽڵ�֧�ֵĿ�ѡ�н���С�
      * TranferQueue  LinkedTransferQueue
      * SynchronousQueue  һ������ BlockingQueue �ӿڵļ򵥾ۼ���rendezvous������
* DelayQueue һ�������ȼ���֧�ֵġ�����ʱ��ĵ��ȶ���

Map
* HashMap LinkedHashMap
* TreeMap
* WeakHashMap
* 

