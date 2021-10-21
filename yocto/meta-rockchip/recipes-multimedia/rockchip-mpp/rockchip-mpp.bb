# Copyright (C) 2016 - 2017 Randy Li <ayaka@soulik.info>
# Copyright (C) 2019, Fuzhou Rockchip Electronics Co., Ltd
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://inc/rk_mpi.h;beginline=4;endline=14;md5=acbba394ae5639b0c786f60c1f48e3d6"

PV_append = "+git${SRCPV}"

inherit freeze-rev local-git

SRCREV = "957b5e0365ecd6db7fd0557daefc5a589ea09419"
SRC_URI = "git://github.com/JeffyCN/mirrors.git;nobranch=1;branch=mpp-dev-2021_08_09;"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

EXTRA_OECMAKE = "     \
    -DRKPLATFORM=ON   \
    -DHAVE_DRM=ON     \
"

CFLAGS += "-D_LARGEFILE64_SOURCE -D_FILE_OFFSET_BITS=64"

PACKAGES = "${PN}-demos ${PN}-dbg ${PN}-staticdev ${PN}-dev ${PN} ${PN}-vpu"
FILES_${PN}-vpu = "${libdir}/lib*vpu${SOLIBS}"
FILES_${PN} = "${libdir}/lib*mpp${SOLIBS}"
FILES_${PN}-dev = "${libdir}/lib*${SOLIBSDEV} ${includedir} ${libdir}/pkgconfig"
FILES_${PN}-demos = "${bindir}/*"
SECTION_${PN}-dev = "devel"
FILES_${PN}-staticdev = "${libdir}/*.a"
SECTION_${PN}-staticdev = "devel"
