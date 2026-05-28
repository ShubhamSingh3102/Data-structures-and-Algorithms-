package Merge_Intervals;

public class Basic_flowchart {
}


//// FlowChart...
// Array me range diya rahe...
// Input ---> Ranges / Intervals
// [Start, end]
// keywords --> Overlap, conflicts, merge, freetime, simultaneous usage, rooms/loads/CPU/meetings




//// Trick...
// [Start, end] --> start se sort kr lena hai
// Overlapping me agar faas gye toh range ko merge kr lena taaki non overlapping ho jaaye


//// 2 question
// Merge krna hai ya nhi
// Merge krna hai to kaise krna hai


//// Trick
// [Start1, end1] [Start2, end2]
// No overlapping means ---> end1 < Start2
// Overlapping means ---> end1 >= Start2

// Aab kaise merge krna hai...
// [Start1, end1]  [Start2, end2]
// Start1 --> min (because starting se sort hai)
// max(end1,end2) --> max

// [Start1, max(end1, end2)]