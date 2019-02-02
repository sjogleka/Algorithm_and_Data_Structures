
import random
import timeit

def swap(arr,a, b):
    temp =arr[a]
    arr[a]=arr[b]
    arr[b]=temp

def median3(arr,start,end):
    center = int((start+end)/2)
    if (arr[center] < arr[start]):
        swap(arr,start,center)
    if (arr[end] < arr[start]):
        swap(arr,start,end)
    if (arr[end] < arr[center]):
        swap(arr,center,end)
    return arr[center]


def insertionSort(arr,left,right):
    for j in range(left, right):
        key = arr[j]
        i = j - 1
        while ((i>=0) and (arr[i] > key)):
            arr[i + 1] = arr[i]
            i = i - 1
        arr[i + 1] = key


def inPlaceQuickSort(array):
    inPlacePartition(array, 0, (len(array) - 1))

def inPlacePartition(array, start, stop):
    if stop - start > 0:
        left = start
        right = stop
        pivot = median3(array,left,right)# Median of three as Pivot
        #print(array)
        #print(pivot)
        if left+10<=right:
            #print("In If")
            while left <= right:
                while array[left] < pivot:
                    left += 1
                while array[right] > pivot:
                    right -= 1
                if left <= right:
                    temp = array[left]
                    array[left] = array[right]
                    array[right] = temp
                    left += 1
                    right -= 1
            inPlacePartition(array, start, right)
            inPlacePartition(array, left, stop)
        else:
            #print("In Insertion Sort")
            insertionSort(array,left,right)


if __name__ == '__main__':
    Time=[0]
    n = [500,1000,2000,4000,5000,10000,20000,30000,40000,50000]
    start = timeit.default_timer()
    for j in range(0, 10):
        arr = []
        for i in range(n[j]):
            arr.append(random.randint(1, n[j]))
        print("########################## For n = ", n[j], "############################")
        print("Before Quick Sort ", arr)
        inPlaceQuickSort(arr)
        print("Sorted Output Using Quick Sort")
        print(arr)
        #print(len(arr),len(x))
        stop = timeit.default_timer()
        Time.append((stop - start))
        print("Time Required :",Time[j+1])

