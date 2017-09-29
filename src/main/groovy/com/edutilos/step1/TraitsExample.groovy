package com.edutilos.step1


class TraitsExample {
   void example1() {
       CustomFile cf1 , cf2, cf3, cf4
       cf1 = new CustomFile()
       cf2 = new CustomFile()
       cf3 = new CustomFile()
       cf4 = new CustomFile()

       cf1.setFilename("foo.read")
       cf2.setFilename("foo.write")
       cf3.setFilename("foo.exe")
       cf4.setFilename("foo.read.write.exe")

       printf("<<infos on %s>>\n", cf1.filename)
       printf("%s is readable = %s\n", cf1.filename, cf1.isReadable())
       printf("%s is writable = %s\n", cf1.filename, cf1.isWritable())
       printf("%s is executable = %s\n", cf1.filename, cf1.isExecutable())
       cf1.read()
       cf1.write()
       cf1.execute()

       println()
       printf("<<infos on %s>>\n", cf2.filename)
       printf("%s is readable = %s\n", cf2.filename, cf2.isReadable())
       printf("%s is writable = %s\n", cf2.filename, cf2.isWritable())
       printf("%s is executable = %s\n", cf2.filename, cf2.isExecutable())
       cf2.read()
       cf2.write()
       cf2.execute()
       println()

       printf("<<infos on %s>>\n", cf3.filename)
       printf("%s is readable = %s\n", cf3.filename, cf3.isReadable())
       printf("%s is writable = %s\n", cf3.filename, cf3.isWritable())
       printf("%s is executable = %s\n", cf3.filename, cf3.isExecutable())
       cf3.read()
       cf3.write()
       cf3.execute()
       println()

       printf("<<infos on %s>>\n", cf4.filename)
       printf("%s is readable = %s\n", cf4.filename, cf4.isReadable())
       printf("%s is writable = %s\n", cf4.filename, cf4.isWritable())
       printf("%s is executable = %s\n", cf4.filename, cf4.isExecutable())
       cf4.read()
       cf4.write()
       cf4.execute()
       println()
   }



   trait Named  {
       String filename
       void setFilename(String filename) {
           this.filename = filename
       }
   }
   trait Readable extends Named{

       boolean isReadable() {
           filename.contains ".read"
       }

       void read() {
           if(isReadable()) {
               println "$filename was read."
           } else {
               println "$filename is not readable."
           }

       }

   }


    trait Writable extends Named {
        boolean isWritable()  {
            filename.contains ".write"
        }

        void write() {
            if(isWritable()) {
                println "$filename was written."
            } else {
                println "$filename is not writable."
            }
        }

    }

    trait Executable extends Named {
        boolean isExecutable() {
            filename.contains ".exe"
        }

        void execute() {
            if(isExecutable()) {
                println "$filename was executed."
            } else {
                println "$filename is not executable."
            }
        }

    }


    class CustomFile implements Readable, Writable, Executable {
    }



}
