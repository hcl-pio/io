/**
 * personium.io
 * Copyright 2014 FUJITSU LIMITED
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fujitsu.dc.core;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fujitsu.dc.core.DcCoreMessageUtils.Severity;

/**
 * ログメッセージ作成クラス.
 */
public final class DcCoreLog {

    static Logger log = LoggerFactory.getLogger(DcCoreLog.class);

    /**
     * OData関連.
     */
    public static class OData {
        /**
         * 主キーでの検索で1件のみ取得できるはずの場所で2件以上のデータが返ってきた.
         * {0}：ヒット件数
         */
        public static final DcCoreLog FOUND_MULTIPLE_RECORDS = create("PL-OD-0001");
        /**
         * バルクデータ登録で異常.
         */
        public static final DcCoreLog BULK_INSERT_FAIL = create("PL-OD-0002");
        /**
         * プロパティ名の重複を検出した.
         */
        public static final DcCoreLog DUPLICATED_PROPERTY_NAME = create("PL-OD-0003");
    }

    /**
     * WebDAV関連.
     */
    public static class Dav {
        /**
         * Roleが見つからなかったとき.
         * {0}：詳細メッセージ
         */
        public static final DcCoreLog ROLE_NOT_FOUND = create("PL-DV-0001");
        /**
         * Rangeヘッダ指定誤り.
         * {0}：詳細メッセージ
         */
        public static final DcCoreLog REQUESTED_RANGE_NOT_SATISFIABLE = create("PL-DV-0002");
        /**
         * Rangeヘッダ指定のファイル読み飛ばし失敗.
         */
        public static final DcCoreLog FILE_TOO_SHORT = create("PL-DV-0003");
    }

    /**
     * 認証関連.
     */
    public static class Auth {
        /**
         * トークンのパースに失敗した時.
         * {0}：詳細メッセージ
         */
        public static final DcCoreLog TOKEN_PARSE_ERROR = create("PL-AU-0001");
        /**
         * トークンの署名検証エラー.
         * {0}：詳細メッセージ
         */
        public static final DcCoreLog TOKEN_DISG_ERROR = create("PL-AU-0002");
        /**
         * ルートCA証明書設定エラー.
         * {0}：詳細メッセージ
         */
        public static final DcCoreLog ROOT_CA_CRT_SETTING_ERROR = create("PL-AU-0003");
        /**
         * 最終ログイン時刻の更新時にAccountが存在しない場合.
         * {0}：詳細メッセージ
         */
        public static final DcCoreLog ACCOUNT_ALREADY_DELETED = create("PL-AU-0004");
    }

    /**
     * サーバ内部エラー.
     * サーバ側の障害やバグにより処理を続行できないときに投げる. 問題の原因を表すようなものとする。 基本的にののカテゴリの例外発生時にはWARN以上のログ出力となる
     */
    public static class Server {
        /**
         * Adsへマスタデータ作成に失敗.
         * {0}：詳細メッセージ
         */
        public static final DcCoreLog DATA_STORE_ENTITY_CREATE_FAIL = create("PL-SV-0001");
        /**
         * Adsへマスタデータ更新に失敗.
         * {0}：詳細メッセージ
         */
        public static final DcCoreLog DATA_STORE_ENTITY_UPDATE_FAIL = create("PL-SV-0002");
        /**
         * Adsへマスタデータ削除に失敗.
         * {0}：詳細メッセージ
         */
        public static final DcCoreLog DATA_STORE_ENTITY_DELETE_FAIL = create("PL-SV-0003");
        /**
         * memcachedのポート番号フォーマットエラー.
         * {0}：詳細メッセージ
         */
        public static final DcCoreLog MEMCACHED_PORT_FORMAT_ERROR = create("PL-SV-0004");
        /**
         * memcachedへの接続に失敗.
         * {0}:ホスト名
         * {1}:ポート名
         * {2}:詳細メッセージ
         */
        public static final DcCoreLog MEMCACHED_CONNECTO_FAIL = create("PL-SV-0005");
        /**
         * memcachedへのcache設定失敗.
         * {0}:詳細メッセージ
         */
        public static final DcCoreLog MEMCACHED_SET_FAIL = create("PL-SV-0006");
        /**
         * memcachedへのcacheクリアー失敗.
         * {0}:詳細メッセージ
         */
        public static final DcCoreLog MEMCACHED_CLEAR_FAIL = create("PL-SV-0007");
        /**
         * memcachedへのcache削除失敗.
         * {0}:詳細メッセージ
         */
        public static final DcCoreLog MEMCACHED_DELETE_FAIL = create("PL-SV-0008");
        /**
         * AdsへBulkでのマスタデータ作成に失敗.
         * {0}:詳細メッセージ
         */
        public static final DcCoreLog DATA_STORE_ENTITY_BULK_CREATE_FAIL = create("PL-SV-0009");
        /**
         * RDBへの接続失敗.
         * {0}:詳細メッセージ
         */
        public static final DcCoreLog RDB_CONNECT_FAIL = create("PL-SV-0010");
        /**
         * SQL実行エラー.
         * {0}:詳細メッセージ
         */
        public static final DcCoreLog EXECUTE_QUERY_SQL_FAIL = create("PL-SV-0011");
        /**
         * RDBとの切断失敗.
         * {0}:詳細メッセージ
         */
        public static final DcCoreLog RDB_DISCONNECT_FAIL = create("PL-SV-0012");
        /**
         * ADSへの接続失敗.
         * {0}:詳細メッセージ
         */
        public static final DcCoreLog ADS_CONNECTION_ERROR = create("PL-SV-0013");
        /**
         * ElasticSearchのインデックスが存在しない.
         * {0}:インデックス名
         */
        public static final DcCoreLog ES_INDEX_NOT_EXIST = create("PL-SV-0014");
        /**
         * Adsの作成に失敗.
         * {0}:インデックス名
         */
        public static final DcCoreLog FAILED_TO_CREATE_ADS = create("PL-SV-0015");
        /**
         * JDBCに対して実行するSQL文をログに出力.
         * {0}:実行したSQL文
         */
        public static final DcCoreLog JDBC_EXEC_SQL = create("PL-SV-0016");
        /**
         * サーバ起動失敗.
         */
        public static final DcCoreLog FAILED_TO_START_SERVER = create("PL-SV-0017");
        /**
         * JDBCに対して実行するユーザODataのSQL実行をログに出力.
         * {0}:DB名
         * {1}:テーブル名
         * {2}:id
         * {3}:タイプ
         * {4}:Cellのid
         * {5}:Boxのid
         * {6}:Nodeのid
         * {7}:EntityTypeのid
         */
        public static final DcCoreLog JDBC_USER_ODATA_SQL = create("PL-SV-0018");
        /**
         * ReferenceOnlyロックを設定した.
         * {0}:キー名
         */
        public static final DcCoreLog SET_REFERENCE_ONLY_LOCK = create("PL-SV-0019");
        /**
         * Adsエラー時のリペア用ログの書込みに失敗.
         */
        public static final DcCoreLog WRITE_ADS_FAILURE_LOG_ERROR = create("PL-SV-0020");
        /**
         * Adsエラー時のリペア用ログに書込む情報.
         * {0}:ログ情報
         */
        public static final DcCoreLog WRITE_ADS_FAILURE_LOG_INFO = create("PL-SV-0021");
    }

    /**
     * ElasticSearch.
     */
    public static class Es {
        /**
         * ESへの接続が完了した.
         * {0}:接続ノードアドレス
         */
        public static final DcCoreLog CONNECTED = create("PL-ES-0001");
        /**
         * ESへのリクエストが完了した.
         * {0}:インデックス名
         * {1}:タイプ名
         * {2}:ノード名
         * {3}:リクエストクエリ
         * {4}:ESへのリクエストタイプ
         * {3}と{4}の出力順は逆になる
         */
        public static final DcCoreLog AFTER_REQUEST = create("PL-ES-0002");
        /**
         * インデックスを作成.
         * {0}:インデックス名
         */
        public static final DcCoreLog CREATING_INDEX = create("PL-ES-0003");
        /**
         * ESへの登録リクエストが完了した.
         * {0}:インデックス名
         * {1}:タイプ名
         * {2}:ノード名
         * {3}:ESへのリクエストタイプ
         * {4}:リクエストクエリ
         */
        public static final DcCoreLog AFTER_CREATE = create("PL-ES-0004");
        /**
         * ESへの登録リクエストが完了した.
         * {0}:リクエストクエリ
         */
        public static final DcCoreLog AFTER_CREATE_BODY = create("PL-ES-0005");
    }

    /**
     * その他エラー.
     */
    public static class Misc {
        /**
         * 到達し得ないソース等の原因不明のエラー.
         */
        public static final DcCoreLog UNREACHABLE_CODE_ERROR = create("PL-MC-0001");
    }

    String message;
    String code;
    Severity severity;
    Throwable reason;

    /**
     * インナークラスを強制的にロードする.
     * エラー分類のインナークラスが追加になったらここに追加すること.
     */
    public static void loadConfig() {
        new OData();
        new Server();
        new Dav();
        new Misc();
    }

    /**
     * コンストラクタ.
     * @param severityエラーレベル
     * @param message エラーメッセージ
     */
    DcCoreLog(final String code,
            final Severity severity,
            final String message) {
        this.code = code;
        this.severity = severity;
        this.message = message;
    }

    /**
     * ファクトリーメソッド.
     * @param code エラーコード
     * @return DcCoreLog
     */
    public static DcCoreLog create(String code) {
        // ログレベルの取得
        Severity severity = DcCoreMessageUtils.getSeverity(code);
        if (severity == null) {
            // 設定ファイルで省略されていたらウォーニング扱いとする。
            severity = Severity.WARN;
        }

        // ログメッセージの取得
        String message = DcCoreMessageUtils.getMessage(code);

        return new DcCoreLog(code, severity, message);
    }

    /**
     * エラーコードを返却する.
     * @return エラーコード
     */
    public String getCode() {
        return this.code;
    }

    /**
     * メッセージをパラメタ置換したものを作成して返します. エラーメッセージ上の {1} {2} 等の表現がパラメタ置換用キーワードです。
     * @param params 付加メッセージ
     * @return DcCoreLog
     */
    public DcCoreLog params(final Object... params) {
        // 置換メッセージ作成
        String ms = MessageFormat.format(this.message, params);
        // メッセージ置換クローンを作成
        DcCoreLog ret = new DcCoreLog(this.code, this.severity, ms);
        return ret;
    }

    /**
     * 原因例外を追加したものを作成して返します.
     * @param t 原因例外
     * @return DcCoreException
     */
    public DcCoreLog reason(final Throwable t) {
        // クローンを作成して
        DcCoreLog ret = new DcCoreLog(this.code, this.severity, this.message);
        // 原因のExceptionをセット
        ret.reason = t;
        return ret;
    }

    /**
     * ログの出力.
     * ログの出力時にログ出力元のクラス名、メソッド名、行数を表示する。
     * 出力例）
     * 2012-09-09 11:23:47.029 [main] [INFO ] DcCoreLog [com.fujitsu.dc.core.DcCoreLogTest#test:22] - JSON Parse Error.
     */
    public void writeLog() {

        StackTraceElement[] ste = (new Throwable()).getStackTrace();
        String logInfo = String.format("[%s] - [%s#%s:%s] - %s",
                this.code, ste[1].getClassName(), ste[1].getMethodName(), ste[1].getLineNumber(), this.message);
        switch (this.severity) {
        case INFO:
            log.info(logInfo, this.reason);
            break;
        case WARN:
            log.warn(logInfo, this.reason);
            break;
        case ERROR:
            log.error(logInfo, this.reason);
            break;
        case DEBUG:
            log.debug(logInfo, this.reason);
            break;
        default:
            log.error("Message Severity Not Defined");
        }
    }
}
