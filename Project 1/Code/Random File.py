import mergeSort
import quickSort
import insertionSort
import random
import timeit
import sys

if __name__ == '__main__':
    Time_Merge = []
    Time_Insertion = []
    Time_Quick = []
    Time_Quick_Median =[]
    avg_Merge = [0]*10
    avg_Insertion =[0]*10
    avg_Quick=[0]*10
    avg_Quick_Median=[0]*10
    #print(avg_Merge)
    print("Please wait ... Execution in progresss....")
    sys.stdout = open("c.txt", "w")
    n = [500,1000,2000,4000,5000,10000,20000,30000,40000,50000]
    start = timeit.default_timer()
    for i in range (0,5):
        print("################# Start of ",i,"Iteration")
        for j in range(0,10):
            arr = []
            for i in range(n[j]):
                arr.append(random.randint(1, n[j]))
            print("########################## For n = ", n[j], "############################")
            arr2 = arr[:]d
            arr3 = arr[:]
            #print("\nInput for Merge Sort", arr)
            x = mergeSort.merge_sort(arr)
            #print("Sorted Output Using Merge Sort")
            #print(x)
            stop = timeit.default_timer()
            Time_Merge.append((stop - start))
            print("Time Required For Merge:", Time_Merge[j])
            #######################################################
            start = timeit.default_timer()
            #print("\nBefore Quick Sort ", arr)
            quickSort.inPlaceQuickSort(arr)
            #print("Sorted Output Using Quick Sort", arr)
            stop = timeit.default_timer()
            Time_Quick.append((stop - start))
            print("Time Required For Quick:", Time_Quick[j])
            ####################################################
            start = timeit.default_timer()
            #print("\nBefore Insertion Sort ", arr2)
            insertionSort.insertionSort(arr2)
            #print("Sorted Output Using Insertion Sort")
            #print(arr2)
            stop = timeit.default_timer()
            Time_Insertion.append((stop - start))
            print("Time Required Insertion:", Time_Insertion[j])
            ########################################################
            start = timeit.default_timer()
            #print("\nBefore Quick (Median of 3) Sort ", arr3)
            quickSort.inPlaceQuickSort(arr3)
            #print("Sorted Output Using Quick(Median of 3) Sort", arr3)
            stop = timeit.default_timer()
            Time_Quick_Median.append((stop - start))
            print("Time Required Quick with Median:", Time_Quick_Median[j])
            avg_Merge[j] = (avg_Merge[j] + Time_Merge[j])
            avg_Quick[j] = (avg_Quick[j] + Time_Quick[j])
            avg_Insertion[j] = (avg_Insertion[j] + Time_Insertion[j])
            avg_Quick_Median[j] = (avg_Quick_Median[j] + Time_Quick_Median[j])


for i in range(0,10):
    print("\n...........................Final Output...............................")
    avg_Merge[i]=avg_Merge[i]/5
    avg_Quick[i] = avg_Quick[i] /5
    avg_Insertion[i] = avg_Insertion[i] / 5
    avg_Quick_Median[i] = avg_Quick_Median[i] / 5
    print("Avg Time for Different Sorting Techniques for n=", n[i])
    print("Insertion Sort :-",avg_Insertion[i])
    print("Merge Sort :-", avg_Merge[i])
    print("Quick Sort :-", avg_Quick[i])
    print("Quick With Median Sort :-", avg_Quick_Median[i])


#print(avg_Merge)
#print(avg_Quick)
#print(avg_Insertion)
#print(avg_Quick_Median)
sys.stdout.close()

