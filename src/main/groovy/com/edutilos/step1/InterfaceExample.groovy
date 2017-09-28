package com.edutilos.step1

import groovy.transform.Canonical

/**
 * Created by edutilos on 28.09.17.
 */
class InterfaceExample {
    interface Readable {
        boolean isReadable();
        void read();
    }

    interface Writable {
        boolean isWritable();
        void write();
    }

    interface Executable {
        boolean isExecutable();
        void execute();
    }

    @Canonical
    static class CustomFile implements Readable, Writable, Executable {
        String filename;

        @Override
        boolean isReadable() {
            filename.contains(".read")
        }

        @Override
        void read() {
            if(isReadable()) {
                printf("%s was read.\n", filename)
            } else {
                printf("%s is not readable.\n", filename)
            }
        }

        @Override
        boolean isWritable() {
            filename.contains(".write")
        }

        @Override
        void write() {
            if(isWritable()) {
                printf("%s was written.\n", filename)
            } else {
                printf("%s is not writable.\n" , filename)
            }
        }

        @Override
        boolean isExecutable() {
            filename.contains(".exe")
        }

        @Override
        void execute() {
            if(isExecutable()) {
                printf("%s was executed.\n", filename)
            } else {
                printf("%s is not executable.\n", filename)
            }
        }
    }
}
