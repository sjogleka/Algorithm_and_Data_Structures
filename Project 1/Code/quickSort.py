
import random
import timeit

def inPlaceQuickSort(array):
    inPlacePartition(array, 0, (len(array) - 1))


def inPlacePartition(array, start, stop):
    #print("In InPlacePartition",array)
    if stop - start > 0:
        left = start
        right = stop
        x = random.randint(start, stop)  # Randomly Choosing Pivot Everytime
        pivot = array[x]
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


if __name__ == '__main__':
    Time=[0]
    n = [500,1000,2000,4000,5000,10000,20000,30000,40000,50000]
    for j in range(0, 10):
        start = timeit.default_timer()
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
