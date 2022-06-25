package eu.qiou.leetcode


class CourseSchedule {

    // https://leetcode.com/problems/course-schedule-iii/
    // 630

    // substitute if it improves the overall utility
    fun scheduleCourse(courses: Array<IntArray>): Int {
        val arr = courses.filter { it.first() <= it.last() }
        val queue = java.util.PriorityQueue<Int> { o1, o2 -> o2.compareTo(o1) }

        if (arr.isEmpty())
            return 0


        var cnt = 0
        arr.sortedBy { it.last() }.forEach {
            val l = it.first()
            val d = it.last()

            if (l + cnt > d){
                val tmp = queue.peek()
               if (queue.peek() > l) {
                  queue.poll()
                  queue.add(l)
                   cnt += l - tmp
               }
            }else{
                queue.add(l)
                cnt += l
            }
        }

        return queue.size
    }
}