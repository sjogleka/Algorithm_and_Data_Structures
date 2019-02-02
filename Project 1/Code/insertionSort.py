import random
import timeit
#import matplotlib.pyplot as plt

def insertionSort(arr):
    for j in range(1, len(arr)):
        key = arr[j]
        i = j - 1
        while ((i>=0) and (arr[i] > key)):
            arr[i + 1] = arr[i]
            i = i - 1
        arr[i + 1] = key

if __name__ == '__main__':
    Time=[0]
    n = [500,1000,2000,4000,5000,10000,20000,30000,40000,50000] # Range to generate random numbers
    for j in range(0,10):
        start = timeit.default_timer()# Start of the timer
        arr = []
        for i in range(n[j]):
            arr.append(random.randint(1, n[j]))#Generating random numbers
        print ("########################## For n = ",n[j],"############################")
        #print (arr)
        print ("Input for Insertion Sort", arr)
        insertionSort(arr)#Calling inserSort to sort the given array arr
        print ("After Applying Insertion Sort", arr)#Printing the array after sorting
        stop = timeit.default_timer()
        Time.append((stop - start))#Calculating time required for the execution
        print (Time[j])#Printing the time required




