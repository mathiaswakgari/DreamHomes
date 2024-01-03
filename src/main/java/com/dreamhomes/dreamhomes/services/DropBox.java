package com.dreamhomes.dreamhomes.services;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.sharing.RequestedVisibility;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import com.dropbox.core.v2.sharing.SharedLinkSettings;

import java.io.*;
import java.util.Date;

public class DropBox {
    private final String appKey = "huxx1tos2ekr270";
    private final String accessToken = "sl.Bs-imLNr0P_WU2za-F_ksKv55oYf4x9XyzTPzt_4EVlFNrwINa-iPJxbWkcfx2iBr5a8TFdNiDMXsaukps3IR6WHT7DAQ_f-LhamzqFSQtkD6uGSbha-hRyHj85Gn7TsAToq91_Pie66AbwPGC718Pg";

    public String upload(File file, int id) throws DbxException {

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/dream-homes").build();
        DbxClientV2 clientV2 = new DbxClientV2(config, this.accessToken);

        //upload to Dropbox
        try(InputStream in = new FileInputStream(file)) {
            FileMetadata metadata = clientV2.files().uploadBuilder("/images/profilePictures/user_" + id + new Date().getTime()+ "_" + ".jpg").uploadAndFinish(in);
            SharedLinkMetadata sharedLinkMetadata = clientV2.sharing().
                    createSharedLinkWithSettings(metadata.getPathDisplay(),
                            SharedLinkSettings.newBuilder().withRequestedVisibility(RequestedVisibility.PUBLIC).build());

            String url = sharedLinkMetadata.getUrl();
            return url.substring(0, url.length() - 1) + "1";
        } catch (IOException | DbxException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
