# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.7

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/ash/projects/ExtractLetters

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/ash/projects/ExtractLetters/build

# Include any dependencies generated for this target.
include CMakeFiles/ExtractLetters.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/ExtractLetters.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/ExtractLetters.dir/flags.make

CMakeFiles/ExtractLetters.dir/main.cpp.o: CMakeFiles/ExtractLetters.dir/flags.make
CMakeFiles/ExtractLetters.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/ash/projects/ExtractLetters/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/ExtractLetters.dir/main.cpp.o"
	/usr/bin/c++   $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/ExtractLetters.dir/main.cpp.o -c /home/ash/projects/ExtractLetters/main.cpp

CMakeFiles/ExtractLetters.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/ExtractLetters.dir/main.cpp.i"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/ash/projects/ExtractLetters/main.cpp > CMakeFiles/ExtractLetters.dir/main.cpp.i

CMakeFiles/ExtractLetters.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/ExtractLetters.dir/main.cpp.s"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/ash/projects/ExtractLetters/main.cpp -o CMakeFiles/ExtractLetters.dir/main.cpp.s

CMakeFiles/ExtractLetters.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/ExtractLetters.dir/main.cpp.o.requires

CMakeFiles/ExtractLetters.dir/main.cpp.o.provides: CMakeFiles/ExtractLetters.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/ExtractLetters.dir/build.make CMakeFiles/ExtractLetters.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/ExtractLetters.dir/main.cpp.o.provides

CMakeFiles/ExtractLetters.dir/main.cpp.o.provides.build: CMakeFiles/ExtractLetters.dir/main.cpp.o


# Object files for target ExtractLetters
ExtractLetters_OBJECTS = \
"CMakeFiles/ExtractLetters.dir/main.cpp.o"

# External object files for target ExtractLetters
ExtractLetters_EXTERNAL_OBJECTS =

ExtractLetters: CMakeFiles/ExtractLetters.dir/main.cpp.o
ExtractLetters: CMakeFiles/ExtractLetters.dir/build.make
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_videostab.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_ts.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_superres.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_stitching.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_ocl.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_gpu.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_contrib.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libboost_filesystem.so
ExtractLetters: /usr/lib/x86_64-linux-gnu/libboost_system.so
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_photo.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_legacy.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_video.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_objdetect.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_ml.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_calib3d.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_features2d.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_highgui.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_imgproc.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_flann.so.2.4.9
ExtractLetters: /usr/lib/x86_64-linux-gnu/libopencv_core.so.2.4.9
ExtractLetters: CMakeFiles/ExtractLetters.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/ash/projects/ExtractLetters/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable ExtractLetters"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/ExtractLetters.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/ExtractLetters.dir/build: ExtractLetters

.PHONY : CMakeFiles/ExtractLetters.dir/build

CMakeFiles/ExtractLetters.dir/requires: CMakeFiles/ExtractLetters.dir/main.cpp.o.requires

.PHONY : CMakeFiles/ExtractLetters.dir/requires

CMakeFiles/ExtractLetters.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/ExtractLetters.dir/cmake_clean.cmake
.PHONY : CMakeFiles/ExtractLetters.dir/clean

CMakeFiles/ExtractLetters.dir/depend:
	cd /home/ash/projects/ExtractLetters/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/ash/projects/ExtractLetters /home/ash/projects/ExtractLetters /home/ash/projects/ExtractLetters/build /home/ash/projects/ExtractLetters/build /home/ash/projects/ExtractLetters/build/CMakeFiles/ExtractLetters.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/ExtractLetters.dir/depend
