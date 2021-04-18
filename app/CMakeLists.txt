cmake_minimum_required(VERSION 3.10.2)

project("myplyaer")

add_library(myplayer
         SHARED
        src/main/cpp/myplayer.cpp)

find_library(log-lib
              log )

include_directories(src/main/cpp/include)
set(my_lib_path  ${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI})
set(CMAKE_CXX_FLAGS  "${CMAKE_CXX_FLAGS} -L${my_lib_path}")

target_link_libraries(myplayer
        avfilter avformat avcodec avutil swresample swscale
        ${log-lib} )