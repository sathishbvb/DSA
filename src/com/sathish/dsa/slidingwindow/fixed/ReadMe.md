# Problems Solved

# 1) Maximum Sum of Subarray of Size K

## ✅ Problem Statement

Given an array of integers and an integer `k`, find the **maximum sum** of any contiguous subarray of size `k`.

---

## 🧠 Approach: Sliding Window

We use a **sliding window** of size `k` to efficiently calculate the sum without re-computing it for every subarray.

---

## 🧾 Steps:

1. Initialize two pointers: `l = 0`, and a running sum `sum = 0`.
2. Iterate through the array with `r` as the right boundary.
3. At each step:
   - Add `arr[r]` to the current sum.
   - If the window size exceeds `k`, shrink it from the left by:
      - Subtracting `arr[l]` from `sum`
      - Incrementing `l`
   - If the window size is exactly `k`, update the maximum sum.

---

## 🧪 Example

**Input:**

```java
arr = [2, 1, 5, 1, 3, 2]
k = 3
** we need to return 5+1+3 = 9 **

