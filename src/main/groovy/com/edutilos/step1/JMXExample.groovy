package com.edutilos.step1

import java.lang.management.*


class JMXExample {
    void example1() {
        def osMXBean = ManagementFactory.operatingSystemMXBean
        def runtimeMXBean = ManagementFactory.runtimeMXBean
        def memoryMXBean = ManagementFactory.memoryMXBean
        def gcMXBeans = ManagementFactory.garbageCollectorMXBeans

        printOsMXBean(osMXBean)
        printRuntimeMXBean(runtimeMXBean)
        printMemoryMXBean(memoryMXBean)
        printGCMXBeans(gcMXBeans)
    }


    private void printGCMXBeans(List<GarbageCollectorMXBean> gcMXBeans) {
        println("<<GarbageCollector MXBeans>>")
        gcMXBeans.each {gc ->
            String[] poolNames = gc.memoryPoolNames
            int collectionCount = gc.collectionCount
            long collectionTime = gc.collectionTime
            println("collectionCount = $collectionCount")
            println("collectionTime = ${new Date(collectionTime)}")
            println("poolNames = ${poolNames.join("; ")}")
            println()
        }
        println()
    }

    private void printMemoryMXBean(MemoryMXBean memoryMXBean) {
        MemoryUsage heapMU = memoryMXBean.heapMemoryUsage
        MemoryUsage nonHeapMU = memoryMXBean.nonHeapMemoryUsage
        int count = memoryMXBean.objectPendingFinalizationCount
        boolean verbose = memoryMXBean.verbose
        println("<<MemoryMXBean>>")
        println("heap Memory Usage: ")
        printMemoryUsage("-", heapMU)
        println("non heap Memory Usage: ")
        printMemoryUsage("-", nonHeapMU)
        println("objectPendingFinalizationCount = $count")
        println("verbose = $verbose")
        println()
    }

    private void printMemoryUsage(String delim , MemoryUsage mu) {
        long init = mu.init
        long used = mu.used
        long committed = mu.committed
        long max = mu.max
        println("$delim init = $init")
        println("$delim used = $used")
        println("$delim committed = $committed")
        println("$delim max = $max")
    }

    private void printRuntimeMXBean(RuntimeMXBean runtimeMXBean) {
        String name = runtimeMXBean.name
        String bootClassPath = runtimeMXBean.bootClassPath
        boolean bootClassPathSupported = runtimeMXBean.bootClassPathSupported
        String classPath = runtimeMXBean.classPath
        List<String> inputArguments = runtimeMXBean.inputArguments
        String libraryPath = runtimeMXBean.libraryPath
        String mxSpecVersion = runtimeMXBean.managementSpecVersion
        String specName = runtimeMXBean.specName
        String specVendor = runtimeMXBean.specVendor
        String specVersion = runtimeMXBean.specVersion
        long startTime = runtimeMXBean.startTime
        long upTime = runtimeMXBean.uptime
        Map<String, String> systemProperties = runtimeMXBean.systemProperties
        String vmName = runtimeMXBean.vmName
        String vmVendor = runtimeMXBean.vmVendor
        String vmVersion = runtimeMXBean.vmVersion
        println("<<Runtime MXBean>>")
        println("name = $name")
        println("bootClassPath = $bootClassPath")
        println("bootClassPathSupported = $bootClassPathSupported")
        println("classPath = $classPath")
        println("inputArguments = ${inputArguments.join("; ")}")
        println("libraryPath = $libraryPath")
        println("mxSpecVersion = $mxSpecVersion")
        println("specName = $specName")
        println("specVendor = $specVendor")
        println("specVersion = $specVersion")
        println("startTime = ${new Date(startTime)}")
        println("uptime = ${new Date(upTime)}")
        println("systemProperties = ${systemProperties.toString()}")
        println("vmName = $vmName")
        println("vmVendor = $vmVendor")
        println("vmVersion = $vmVersion")
        println()
    }

    private void printOsMXBean(OperatingSystemMXBean osMXBean) {
        println("<<OperationSystem MXBean>>")
        String arch = osMXBean.arch
        int processors = osMXBean.availableProcessors
        String name = osMXBean.name
        double systemLoadAverage = osMXBean.systemLoadAverage
        String version = osMXBean.version
        println("arch = $arch")
        println("available processors = $processors")
        println("name = $name")
        println("systemLoadAverage = $systemLoadAverage")
        println("version = $version")
        println()
    }
}
