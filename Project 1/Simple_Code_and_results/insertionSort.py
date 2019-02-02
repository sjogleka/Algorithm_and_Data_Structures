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
        Time = [0]
        start = timeit.default_timer()
        arr=[3,65,55,112,90,45,0,12,6,2,99]
        arr1=[7,6,5,4,3,2,1]
        arr2=[1,2,3,4,5,6,7,8,99]
        #print (arr)
        print ("Input for Insertion Sort", arr2)
        insertionSort(arr2)#Calling inserSort to sort the given array arr
        print ("After Applying Insertion Sort", arr2)#Printing the array after sorting
        stop = timeit.default_timer()
        Time.append((stop - start))
        print("Time Required :", Time[1])




