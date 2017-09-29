package com.edutilos.step1

import groovy.transform.Canonical

import java.io.File



class FileIOExample {
    //writing into file
    void example1() {
        new File("Workers.txt").withWriter {writer->
            def workers = generateWorkers()
            workers.forEach {worker->
                writer.writeLine worker.toString()
            }
        }
    }

    //reading from file
    void example2() {
        def workers = []
        new File("Workers.txt").eachLine { line ->
            workers.add convertLineToWorker(line)
        }

        println("<<All Workers>>")
        workers.forEach { worker ->
            println worker.toString()
        }
        println()
        String content = new File("Workers.txt").text
        def lines = content.split("\n")
        workers = []
        for(def line : lines) {
            workers.add convertLineToWorker(line)
        }

        println("<<All Workers>>")
        workers.forEach {worker->
            println worker.toString()
        }

    }


    //some file methods
    void example3() {
        /*
        isInvalid(): boolean  : package default
getName(): String
getParent(): String
getParentFile(): File
getPath(): String
isAbsolute():boolean
getAbsolutePath():String
getAbsoluteFIle(): File
getCanonicalPath():String
getCanonicalFile(): File
canRead(): boolean
canWrite(): boolean
exists(): boolean
isDirectory(): boolean
isFile(): boolean
isHidden(): boolean
lastModified(): long
length(): long
list(): String[]
list(FilenameFilter): String[]
listFiles(): File[]
listFiles(FilenameFilter):File[]
listFiles(FileFilter): File[]
canExecute(): boolean
listRoots(): FIle[]
getTotalSpace(): long
getFreeSpace(): long
getUsableSpace(): long
compareTo(File): int
equals(Object): boolean
hashCode(): int
toString(): String
toPath(): Path
*/
        File file = new File("Workers.txt")
        String name = file.getName()
        String parent = file.getParent()
        File parentFile = file.getParentFile()
        String path = file.getPath()
        boolean isAbsolute = file.isAbsolute()
        String absolutePath = file.getAbsolutePath()
        File absoluteFile = file.getAbsoluteFile()
        String canonicalPath = file.getCanonicalPath()
        File canonicalFile = file.getCanonicalFile()
        boolean canRead = file.canRead()
        boolean canWrite = file.canWrite()
        boolean canExecute = file.canExecute()
        boolean exists = file.exists()
        boolean isDirectory = file.isDirectory()
        boolean isFile = file.isFile()
        boolean isHidden = file.isHidden()
        long lastModified = file.lastModified()
        long length = file.length()
        long totalSpace = file.getTotalSpace()
        long freeSpace = file.getFreeSpace()
        long usableSpace = file.getUsableSpace()

        printf("<<infos on %s>>\n", file.getName())
        printf("name = %s\n", name)
        if(parent != null)
        printf("parent = %s\n", parent)
        if(parentFile != null)
        printf("parentFile = %s\n", parentFile.getAbsolutePath())
        printf("path = %s\n", path)
        printf("isAbsolute = %s\n", isAbsolute)
        printf("absolutePath = %s\n", absolutePath)
        printf("absoluteFile = %s\n", absoluteFile.getAbsolutePath())
        printf("canonicalPath = %s\n", canonicalPath)
        printf("canonicalFile = %s\n", canonicalFile.getAbsolutePath())
        printf("canRead = %s\n", canRead)
        printf("canWrite = %s\n", canWrite)
        printf("canExecute = %s\n", canExecute)
        printf("exists = %s\n", exists)
        printf("isDirectory = %s\n", isDirectory)
        printf("isFile = %s\n", isFile)
        printf("isHidden = %s\n", isHidden)
        printf("lastModifed = %s\n", lastModified)
        printf("length = %d\n", length)
        printf("totalSpace = %d\n", totalSpace)
        printf("freeSpace = %d\n", freeSpace)
        printf("usableSpace = %d\n", usableSpace)
        printf("lastModifed = %s\n", new Date(lastModified))

/*
createNewFile(): boolean
delete(): boolean
deleteOnExit():void
mkdir(): boolean
mkdirs(): boolean
renameTo(File): boolean
setLastModified(long): boolean
setReadOnly():boolean
setWritable(boolean, boolean): boolean
setWritable(boolean): boolean
setReadable(boolean, boolean): boolean
setReadable(boolean): boolean
setExecutable(boolean , boolean): boolean
setExecutable(boolean): boolean
createTempFile(String , String , File): File
createTempFile(String, String): File
writeObject(ObjectOutputStream): void
readObject(ObjectInputStream): void

         */
    }



    //directory operations
    void example4() {
        File file = new File("tmp")
        //creating dir
        if(file.mkdir()) {
            println("created dir successfully.")
        } else {
            println("could not create dir.")
        }


        //deleting dir
        if(file.delete()) {
            println("deleted dir successfully.")
        } else {
            println("could not delete dir.")
        }


       //copying file content
        File src = new File("Workers.txt")
        File dest = new File("DestWorkers.txt")
        dest << src.text

        //reading content of dest
        dest.eachLine{line ->
            println(line)
        }

        //removing dest
        dest.delete()


        //listing all files
        println()
        def rootFiles = new File("src/main/groovy/com/edutilos/step1","ComplexNumber.groovy").listRoots()
        rootFiles.each  {f ->
            println f.getAbsolutePath()  // /
        }
        println()

        new File("src/main/groovy/com/edutilos/step1").eachFile{ f->
            println f.getAbsolutePath()
        }
        println()

        new File("src/main/groovy").eachFile{ f->
            println f.getAbsolutePath()
        }
        println()

        new File("src/main/groovy").eachFileRecurse{ f->
            println f.getAbsolutePath()
        }
        println()
    }



    void example5() {
        /*
        list(): String[]
list(FilenameFilter): String[]
listFiles(): File[]
listFiles(FilenameFilter):File[]
listFiles(FileFilter): File[]
         */

        File file = new File("src/main/groovy/com/edutilos/step1")
        String[] files = file.list()
        println("<<list()>>")
        for(def f: files) {
            println f
        }
        println()

        files = file.list {dir, name ->
            name.contains "Complex"
        }


        println("<<list(FilenameFilter)>>")
        for(def f: files) {
            println f
        }
        println()

        File[] files2 = file.listFiles()
        println("<<listFiles()>>")
        for(def f: files2) {
            println f.getAbsolutePath()
        }
        println()

        //in order to avoid ambigious overload of closure
        files2 = file.listFiles ({dir, name ->
            name.contains "Complex"
        } as FilenameFilter)
        println("<<listFiles(FileNameFilter)>>")
        for(def f: files2) {
            println f.getAbsolutePath()
        }
        println()

        //in order to avoid ambigious overload of closure
        files2 = file.listFiles ({ path ->
            path.getAbsolutePath().contains "In"
        } as FileFilter)

        println("<<listFiles(FileFilter)>>")
        for(def f: files2) {
            println f.getAbsolutePath()
        }
        println()


    }


    private Worker convertLineToWorker(String line) {
        String[] splitted = line.split(",")
        new Worker(
                splitted[0].toLong(),
                splitted[1],
                splitted[2].toInteger(),
                splitted[3].toDouble(),
                splitted[4].toBoolean()
        )
    }
    private List<Worker> generateWorkers() {
        [
                new Worker(1, "foo", 10, 100.0, true),
                new Worker(2, "bar", 20, 200.0, false),
                new Worker(3, "bim", 30, 300.0, true)
        ]
    }

    @Canonical
    class Worker {
        long id
        String name
        int age
        double wage
        boolean active

        @Override
        String toString() {
            String.format("%d,%s,%d,%.2f,%s", id , name, age, wage, active)
        }
    }
}
